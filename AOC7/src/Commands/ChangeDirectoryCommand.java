package Commands;

import FilesNFolders.HardDriveItem;
import FilesNFolders.ListedDirectory;

public class ChangeDirectoryCommand implements Command {
    //Role: to place a new file on the file Tree
    //Return a new directory
    String location;
    ChangeType type;

    public ChangeDirectoryCommand(String location, ChangeType type){
        this.location = location;
        this.type = type;
    }

    @Override
    public String toString() {
        return location + ", " + type.toString();
    }

    @Override
    public HardDriveItem[] execute() {
        ListedDirectory directory = new ListedDirectory(location);
        return new ListedDirectory[]{directory};
    }

    public ChangeType getType() {
        return type;
    }
}
