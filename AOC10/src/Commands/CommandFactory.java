package Commands;

import java.util.ArrayList;

public class CommandFactory {

    public Command makeCommand(String input){
        String[] inputs = input.split(" ");
        if (inputs[0].trim().equals("noop")){
            return new Wait();
        }
        return new Add(Integer.valueOf(inputs[1].trim()));

    }

    public Command[] makeCommands(String[] input){
        ArrayList<Command> commands = new ArrayList<Command>(input.length);
        for (String commandString : input){
            commands.add(makeCommand(commandString));
        }
        return commands.toArray(new Command[0]);
    }
}
