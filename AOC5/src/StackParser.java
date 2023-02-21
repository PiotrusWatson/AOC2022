import java.util.ArrayList;

public class StackParser {


    String[][] crateList;
    ArrayList<String> commandStrings;
    public StackParser(ArrayList<String> input){

        ArrayList<String[]> unprocessedCrateList = new ArrayList<>();
        ArrayList<String>[] splitLists = splitListOnNewLine(input);
        commandStrings = splitLists[1];
        ArrayList<String> crateStrings = splitLists[0];

        for (String line : crateStrings){
            unprocessedCrateList.add(splitOnAmount(line, 4));
        }

        int longest = getLongestSplit(unprocessedCrateList);
        crateList = crateList = new String[unprocessedCrateList.size()][longest];


        for (int i = 0; i < unprocessedCrateList.size(); i++){
            for (int j = 0; j < longest; j++){
                if (j >= unprocessedCrateList.get(i).length){
                    break;
                }
                crateList[i][j] = unprocessedCrateList.get(i)[j];
            }
        }

        for (int i = 0; i < crateList.length; i++){
            for (int j = 0; j < crateList[i].length; j++){
                if (crateList[i][j] == null){
                    crateList[i][j] = "    ";
                }
            }
        }


    }


    public String[][] getCrateList() {
        return crateList;
    }

    public ArrayList<String> getCommandStrings() {
        return commandStrings;
    }

    public CrateStacks buildCrateStacks(){
        return new CrateStacks(crateList);
    }

    public ArrayList<Command> buildCommandList(){
        ArrayList<Command> commands = new ArrayList<>(commandStrings.size());
        for (String commandString : commandStrings){
            commands.add(new Command(commandString));
        }
        return commands;
    }

    public static String[] splitOnAmount(String input, int amount){
        ArrayList<String> output = new ArrayList<String>((input.length() + amount - 1) / amount);

        for (int i = 0; i < input.length(); i+= amount){
            output.add(input.substring(i, Math.min(input.length(), i + amount)));

        }
        return output.toArray(new String[0]);
    }

    public static ArrayList<String>[] splitListOnNewLine(ArrayList<String> input){
        ArrayList<String> crateStuff = new ArrayList<String>();
        ArrayList<String> commands = new ArrayList<String>();
        for (String line: input){
            if (line.compareTo("\n") == 0){
                continue;
            }
            if (line.startsWith("move")){
                commands.add(line);
            }
            else {
                crateStuff.add(line);
            }
        }

        crateStuff.remove(crateStuff.size() - 1);

        return new ArrayList[]{crateStuff, commands};

    }

    public static int getLongestSplit(ArrayList<String[]> crateList){
        int biggestLength = 0;
        for (String[] crateStrings : crateList){
            if (crateStrings.length > biggestLength){
                biggestLength = crateStrings.length;
            }
        }
        return biggestLength;
    }


}
