package Commands;

import static org.junit.jupiter.api.Assertions.*;

class CommandFactoryTest {

    @org.junit.jupiter.api.Test
    void makeCommandMakesCorrectCommand() {
        CommandFactory factory = new CommandFactory();
        Command result = factory.makeCommand("addx 15\n");
        assertTrue(result instanceof Add);
        result = factory.makeCommand("noop\n");
        assertTrue(result instanceof Wait);
    }
}