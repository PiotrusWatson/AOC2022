package FilesNFolders;

import FilesNFolders.HardDriveItem;

public class ListedFile implements HardDriveItem {
    long size;
    String name;

    public ListedFile(long size, String name){
        this.size = size;
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    @Override
    public boolean isCounted() {
        return true;
    }

    public String toString(){
        return name + ", " + String.valueOf(size);
    }
}
