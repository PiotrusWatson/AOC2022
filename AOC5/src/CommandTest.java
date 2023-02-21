import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {
    @Test
    public void commandCorrectlyParsesACommand(){
        Command command = new Command("move 1 from 2 to 1\n");
        assertEquals(command.getAmountToPop(), 1);
        assertEquals(1, command.getFromIndex());
        assertEquals(0, command.getToIndex());
    }

}