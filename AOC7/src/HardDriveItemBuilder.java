import FilesNFolders.HardDriveItem;
import FilesNFolders.ListedDirectory;
import FilesNFolders.ListedFile;

public class HardDriveItemBuilder {

    public HardDriveItem buildHardDriveItem(String input){
        String[] splitInput = input.split(" ");
        if (isNumeric(splitInput[0])){
            int size = Integer.valueOf(splitInput[0]);
            return new ListedFile(size, splitInput[1]);
        }
        else {
            return new ListedDirectory(splitInput[1]);
        }
    }
    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

}
