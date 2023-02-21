import FilesNFolders.HardDriveItem;
import FilesNFolders.ListedDirectory;
import FilesNFolders.ListedFile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HardDriveItemBuilderTest {

    @Test
    void buildHardDriveItemMakesCorrectHardDriveItem() {
        String file = "14848514 b.txt";
        String dir = "dir a";
        HardDriveItemBuilder builder = new HardDriveItemBuilder();
        HardDriveItem listedFile = builder.buildHardDriveItem(file);
        HardDriveItem listedDir = builder.buildHardDriveItem(dir);
        assertTrue(listedFile instanceof ListedFile);
        assertTrue(listedDir instanceof ListedDirectory);
        assertEquals("b.txt, 14848514", listedFile.toString());
        assertEquals("a, 0", listedDir.toString());

    }
}