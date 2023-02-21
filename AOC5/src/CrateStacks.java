import java.util.ArrayList;
import java.util.Stack;

public class CrateStacks {
    ArrayList<Stack<Crate>> stacks;

    public ArrayList<Stack<Crate>> getStacks() {
        return stacks;
    }

    public CrateStacks(String[][] input){
        stacks = new ArrayList<Stack<Crate>>();
        int length = input[0].length;
        for (int i = 0; i < length; i++){
            Stack<Crate> stack = new Stack<>();

            for (int j = input.length - 1; j >= 0; j--){
                String crateData = input[j][i];

                if (!Character.isWhitespace(crateData.charAt(1))){
                    stack.push(new Crate(crateData));
                }

            }
            stacks.add(stack);
        }
    }
    public Crate popFrom(int index){
        return stacks.get(index).pop();
    }

    public void pushTo(Crate item, int index){
        stacks.get(index).push(item);
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for (Stack<Crate> stack : stacks){
            builder.append(stack.peek().toString());
        }
        return builder.toString();
    }

}
