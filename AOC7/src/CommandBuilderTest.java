import Commands.ChangeDirectoryCommand;
import Commands.Command;
import Commands.ListCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandBuilderTest {

    @org.junit.jupiter.api.Test
    void parseChangeDirectoryWorksForAllCases() {
        String go_out = " cd ..";
        String go_in = " cd apple";
        String go_home = " cd /";
        CommandBuilder builder = new CommandBuilder();
        ChangeDirectoryCommand command = (ChangeDirectoryCommand) builder.parseChangeDirectory(go_out);
        assertEquals(command.toString(), ".., OUT");
        command = (ChangeDirectoryCommand) builder.parseChangeDirectory(go_in);
        assertEquals(command.toString(), "apple, IN");
        command = (ChangeDirectoryCommand) builder.parseChangeDirectory(go_home);
        assertEquals(command.toString(), "/, HOME");

    }

    @Test

    void createCommandSpitsOutCorrectType() {
        String cd = " cd ..\n";
        String ls = " ls\n" +
                "dir a\n" +
                "14848514 b.txt\n" +
                "8504156 c.dat\n" +
                "dir d";

        CommandBuilder builder = new CommandBuilder();
        Command cdCommand = builder.createCommand(cd);
        Command lsCommand = builder.createCommand(ls);
        assertTrue(cdCommand instanceof ChangeDirectoryCommand);
        assertTrue(lsCommand instanceof ListCommand);
        assertEquals(".., OUT", cdCommand.toString());
        assertEquals("a\nb.txt, 14848514\nc.dat, 8504156\nd\n", lsCommand.toString());
    }
}