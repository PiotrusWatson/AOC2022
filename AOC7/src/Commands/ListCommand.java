package Commands;

import Commands.Command;
import FilesNFolders.HardDriveItem;

import java.util.ArrayList;

public class ListCommand implements Command {
    //role: to fill the fileList of a given node
    ArrayList<HardDriveItem> fileList;

    public ListCommand(ArrayList<HardDriveItem> fileList){
        this.fileList = fileList;
    }

    public String toString(){
        StringBuilder fileString = new StringBuilder();
        for (HardDriveItem item : fileList){
            fileString.append(item.toString() + "\n");
        }
        return fileString.toString();
    }

    @Override
    public HardDriveItem[] execute() {
        return fileList.toArray(new HardDriveItem[0]);
    }
}
