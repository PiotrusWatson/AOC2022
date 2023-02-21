package Commands;

import FilesNFolders.HardDriveItem;
import FilesNFolders.ListedDirectory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChangeDirectoryCommandTest {

    @Test
    void executeReturnsCorrectly() {
        ChangeDirectoryCommand command = new ChangeDirectoryCommand("/", ChangeType.HOME);
        HardDriveItem[] returned = command.execute();
        assertEquals(1, returned.length);
        assertTrue(returned[0] instanceof ListedDirectory);
        assertEquals("/", returned[0].toString());


    }
}