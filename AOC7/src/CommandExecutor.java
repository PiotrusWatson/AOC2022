import Commands.ChangeDirectoryCommand;
import Commands.Command;
import Commands.ChangeType;
import Commands.ListCommand;
import FilesNFolders.HardDriveItem;
import FilesNFolders.ListedDirectory;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

public class CommandExecutor {
    Command[] commands;
    FileTree fileTree;

    public CommandExecutor(FileTree fileTree, Command[] commands){
        this.fileTree = fileTree;
        this.commands = commands;

    }

    public void executeAll(){
        for (Command command : commands){
            try {
                execute(command);
            }
            catch (Exception e){
                System.out.println(e.toString());
                System.out.println("Stopping...");
                return;
            }
        }
        System.out.println(fileTree.getLength());
    }
    public void execute(Command command) throws Exception{
        HardDriveItem[] results = command.execute();
        if (command instanceof ChangeDirectoryCommand){
            ChangeType type = ((ChangeDirectoryCommand) command).getType();
            ListedDirectory directory = (ListedDirectory) results[0];
            executeCD(directory, type);
        }
        else if (command instanceof ListCommand){
            fileTree.setCurrentFiles(results);
        }
        else {
            throw new Exception("Command " + command.toString() + " is neither of the two options");
        }
    }

    public void executeCD(ListedDirectory toChange, ChangeType type) throws Exception{
        HardDriveItem[] subItems = fileTree.getCurrentFiles();
        boolean foundIt = false;
        switch (type){
            case HOME:
                fileTree.goHome();
                break;
            case OUT:
                fileTree.goBack();
                break;
            default:
                for (HardDriveItem item : subItems){
                    if (item instanceof ListedDirectory && item.equals(toChange) && !toChange.getHasTraversed()){
                        fileTree.goIn((ListedDirectory) item);
                        foundIt = true;
                        break;
                    }
                    else if (item instanceof ListedDirectory && item.equals(toChange)){
                        fileTree.travelIn((ListedDirectory) item);
                        foundIt = true;
                        break;
                    }
            }if (!foundIt){
                throw new Exception("Folder not found in current directory");
            }

        }
    }




}
