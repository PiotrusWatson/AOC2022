import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandParserTest {

    @Test
    void parseParsesCorrectly() {
        CommandParser parser = new CommandParser();
        String commandText = "R 4\n";
        try{
            Command newCommand = parser.parse(commandText);
            assertEquals(4, newCommand.iterations);
            assertEquals(1, newCommand.coord.x);
            assertEquals(0, newCommand.coord.y);
            commandText = "U 2";
            newCommand = parser.parse(commandText);
            assertEquals(2, newCommand.iterations);
            assertEquals(0, newCommand.coord.x);
            assertEquals(1, newCommand.coord.y);
            commandText = "L 5";
            newCommand = parser.parse(commandText);
            assertEquals(5, newCommand.iterations);
            assertEquals(-1, newCommand.coord.x);
            assertEquals(0, newCommand.coord.y);
            commandText = "D 1";
            newCommand = parser.parse(commandText);
            assertEquals(1, newCommand.iterations);
            assertEquals(0, newCommand.coord.x);
            assertEquals(-1, newCommand.coord.y);
        }
        catch (Exception e){

        }



    }
}