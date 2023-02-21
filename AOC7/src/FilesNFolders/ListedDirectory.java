package FilesNFolders;

import FilesNFolders.HardDriveItem;

import java.util.ArrayList;
import java.util.Objects;

public class ListedDirectory implements HardDriveItem {
    String name;

    boolean counted = false;
    HardDriveItem[] subItems;
    ListedDirectory parent;

    long totalSize;
    boolean hasTraversed = false;

    public ListedDirectory(String name) {

        this.name = name;
        parent = null;
    }

    public String toString(){
        return name + ", " + totalSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListedDirectory that = (ListedDirectory) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public HardDriveItem[] getSubItems() {
        return subItems;
    }

    public ListedDirectory getParent() {
        return parent;
    }

    public void setParent(ListedDirectory parent) {
        this.parent = parent;
    }

    public void setSubItems(HardDriveItem subItems[]) {
        this.subItems = subItems;
    }

    @Override
    public boolean isCounted() {
        return counted;
    }

    public long getSize(){
        return totalSize;
    }

    public ListedDirectory getFirstNotCounted(){
        for (HardDriveItem item: subItems){
            if (!item.isCounted()){
                return (ListedDirectory) item;
            }
        }
        return null;
    }
    public void calculateSize(){
        long newSize = 0;
        for (HardDriveItem item : subItems){
            newSize += item.getSize();
        }
        totalSize = newSize;
        counted = true;
    }

    public boolean getHasTraversed(){
        return hasTraversed;
    }

    public void setHasTraversed(){
        hasTraversed = true;
    }

}
