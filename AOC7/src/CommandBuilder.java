import Commands.ChangeDirectoryCommand;
import Commands.ChangeType;
import Commands.Command;
import Commands.ListCommand;
import FilesNFolders.HardDriveItem;

import java.util.ArrayList;

public class CommandBuilder {


    HardDriveItemBuilder fileBuilder;

    public CommandBuilder(){
        fileBuilder = new HardDriveItemBuilder();
    }
    public Command createCommand(String inputData){
        if (inputData.startsWith(" cd")){
            return parseChangeDirectory(inputData);
        }
        else if (inputData.startsWith(" ls")){
            return parseLS(inputData);
        }

        return null;
    }

    public ChangeDirectoryCommand parseChangeDirectory(String line){
        String processedLine = line.trim();
        String[] commandStructure = processedLine.split(" ");
        String location = commandStructure[1];
        switch (location){
            case "/":
                return new ChangeDirectoryCommand("/", ChangeType.HOME);
            case "..":
                return new ChangeDirectoryCommand("..", ChangeType.OUT);
            default:
                return new ChangeDirectoryCommand(location, ChangeType.IN);
        }

    }

    public Command parseLS(String text){
        String[] fileStrings = text.split("\n");
        ArrayList<HardDriveItem> files = new ArrayList<HardDriveItem>(fileStrings.length - 1);
        for (int i = 1; i < fileStrings.length; i++){
            files.add(fileBuilder.buildHardDriveItem(fileStrings[i]));
        }
        return new ListCommand(files);
    }
}
