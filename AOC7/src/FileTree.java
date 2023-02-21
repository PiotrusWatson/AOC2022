import Commands.ChangeDirectoryCommand;
import Commands.ListCommand;
import FilesNFolders.HardDriveItem;
import FilesNFolders.ListedDirectory;

import java.util.ArrayList;

public class FileTree {

    ListedDirectory root;
    ListedDirectory cursor;
    int size;
    public FileTree(){
        root = null;
        cursor = null;
        size = 0;
    }

    public void init(ChangeDirectoryCommand first){
        ListedDirectory toChange = (ListedDirectory) first.execute()[0];
        root = toChange;
        cursor = toChange;
        size = 1;
    }

    public HardDriveItem[] getCurrentFiles(){
        return cursor.getSubItems();
    }
    public boolean atHome(){
        return cursor == root;
    }
    public void setCurrentFiles(HardDriveItem[] subItems){
        cursor.setSubItems(subItems);
    }
    public void goHome(){
        cursor = root;
    }

    public void goBack(){
        cursor = cursor.getParent();
    }

    public void goIn(ListedDirectory newdir){
        newdir.setParent(cursor);
        cursor = newdir;
        newdir.setHasTraversed();
        size += 1;
    }

    public void travelIn(ListedDirectory newdir){
        cursor = newdir;
    }

    public void count(){
        cursor.calculateSize();
    }

    public boolean isCurrentlyCounted(){
        return cursor.isCounted();
    }

    public long getSize(){
        return cursor.getSize();
    }

    public int getLength() {
        return size;
    }
    public ListedDirectory getFirstNotCounted(){
        return cursor.getFirstNotCounted();
    }

    public boolean beenHereBefore(){
        return cursor.getHasTraversed();
    }



}
