import Commands.ChangeDirectoryCommand;
import Commands.Command;

import java.util.ArrayList;
import java.util.Arrays;

public class CommandExecutorBuilder {

    CommandBuilder commandBuilder;

    public CommandExecutorBuilder(){
        commandBuilder = new CommandBuilder();
    }

    public CommandExecutor buildCommandExecutor(String godText){
        String[] unProcessedcommandStrings = godText.split("\\$");
        String[] commandStrings = Arrays.copyOfRange(unProcessedcommandStrings, 1, unProcessedcommandStrings.length);
        ArrayList<Command> commands = new ArrayList<>(commandStrings.length);
        for (String commandString : commandStrings){
            commands.add(commandBuilder.createCommand(commandString));
        }

        FileTree fileTree = new FileTree();
        ChangeDirectoryCommand firstCommand = (ChangeDirectoryCommand) commands.get(0);
        commands.remove(0);
        fileTree.init(firstCommand);
        return new CommandExecutor(fileTree, commands.toArray(new Command[0]));



    }
}
