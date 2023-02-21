import java.util.ArrayList;

public class CommandParser {

    public Command parse(String commandString) throws Exception{
        String[] commandParts = commandString.split(" ");
        Coord newCoord = letterToCoord(commandParts[0]);
        int iterations = Integer.valueOf(commandParts[1].trim());
        return new Command(newCoord, iterations);
    }

    public Command[] parseAll(String[] commandStrings) throws Exception{
        ArrayList<Command> commands = new ArrayList<>(commandStrings.length);
        for (String commandString : commandStrings){
            commands.add(parse(commandString));
        }
        return commands.toArray(new Command[0]);
    }

    private Coord letterToCoord(String letter) throws Exception{
        switch (letter){
            case "R":
                return new Coord(1, 0);
            case "L":
                return new Coord(-1, 0);
            case "U":
                return new Coord(0, 1);
            case "D":
                return new Coord(0, -1);
            default:
                throw new Exception("Unexpected text! Stopping...");
        }
    }
}
