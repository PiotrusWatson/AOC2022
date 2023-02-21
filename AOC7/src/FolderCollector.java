import FilesNFolders.HardDriveItem;
import FilesNFolders.ListedDirectory;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class FolderCollector {

    FileTree tree;
    long maxSize;
    long minSize;
    ArrayList<ListedDirectory> collectedFolders;
    ArrayList<ListedDirectory> greaterThanFolders;
    public FolderCollector(FileTree tree, long maxSize, long minSize){
        this.tree = tree;
        this.maxSize = maxSize;
        this.minSize = minSize;
        collectedFolders = new ArrayList<>();
        greaterThanFolders = new ArrayList<>();
    }

    public void collectFolders(){
        while (!tree.atHome() || !tree.isCurrentlyCounted()){
                System.out.println(tree.cursor);
                System.out.println(Arrays.toString(tree.getCurrentFiles()));
                ListedDirectory notCounted = tree.getFirstNotCounted();
                if (notCounted != null){
                    tree.travelIn(notCounted);
                }
                else{
                    tree.count();
                    collectedFolders.addAll(storeFolders());
                    if (!tree.atHome())
                    {
                        tree.goBack();
                    }
                }
        }
        System.out.println(tree.cursor);
        System.out.println(Arrays.toString(tree.getCurrentFiles()));

    }

    public ArrayList<ListedDirectory> storeFolders(){
        ArrayList<ListedDirectory> storedFolders = new ArrayList<>();
        for (HardDriveItem item : tree.getCurrentFiles()){
            if (item instanceof ListedDirectory && item.getSize() <= maxSize){
                storedFolders.add((ListedDirectory) item);
            }
            if (item instanceof ListedDirectory && item.getSize() >= minSize){
                greaterThanFolders.add((ListedDirectory) item);
            }
        }
        return storedFolders;
    }

    public long sumFolders(){
        long total = 0;
        for (ListedDirectory folder : collectedFolders){
            total += folder.getSize();
        }
        return total;
    }

    public long smallestItem(){
        long smallest = greaterThanFolders.get(0).getSize();
        for (ListedDirectory folder: greaterThanFolders){
            if (folder.getSize() < smallest){
                smallest = folder.getSize();
            }
        }
        return smallest;

    }

}
