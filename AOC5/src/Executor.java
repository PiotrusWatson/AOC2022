import java.util.ArrayList;
import java.util.Stack;

public class Executor {
    ArrayList<Command> commands;
    CrateStacks crateStacks;

    Stack<Crate> tempStack;

    public Executor(ArrayList<Command> commands, CrateStacks crateStacks){
        this.commands = commands;
        this.crateStacks = crateStacks;
        tempStack = new Stack<Crate>();
    }

    public void executeAll(){
        int amountToPop;
        int from;
        int to;
        System.out.println(commands.size());
        for (Command command : commands){

            amountToPop = command.getAmountToPop();
            from = command.getFromIndex();
            to = command.getToIndex();
            execute(amountToPop, from, to);
        }
    }

    public void executeAllInOrder(){
        int amountToPop;
        int from;
        int to;
        System.out.println(commands.size());
        for (Command command : commands){

            amountToPop = command.getAmountToPop();
            from = command.getFromIndex();
            to = command.getToIndex();
            executeInOrder(amountToPop, from, to);
        }
    }

    public void execute(int popAmount, int from, int to){
        for (int i = 0; i < popAmount; i++){
            Crate crate = crateStacks.popFrom(from);
            crateStacks.pushTo(crate, to);
        }
    }

    public void executeInOrder(int popAmount, int from, int to){
        for (int i = 0; i < popAmount; i++){
            Crate crate = crateStacks.popFrom(from);
            tempStack.push(crate);
        }

        for (int i = 0; i < popAmount; i++){
            Crate crate = tempStack.pop();
            crateStacks.pushTo(crate, to);
        }
        tempStack.clear();
    }
}
