package Commands;

import FilesNFolders.HardDriveItem;

public interface Command {
    public HardDriveItem[] execute();
}
