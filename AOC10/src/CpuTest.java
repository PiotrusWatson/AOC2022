import Commands.Command;
import Commands.CommandFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CpuTest {

    @Test
    void executeTicksCorrectlyAndReturnsItems() {
        String[] commandStrings = {
                "addx 15",
                "noop",
                "noop",
                "addx -5"
        };
        CommandFactory factory = new CommandFactory();
        Command[] commands = factory.makeCommands(commandStrings);
        Clock clock = new Clock();
        PixelScreen screen = new PixelScreen(6, 40);
        Cpu cpu = new Cpu(clock, screen);
        cpu.addCommand(commands[0]);
        cpu.execute();
        assertEquals(0, cpu.register);
        assertEquals(1, cpu.getTime());
        assertEquals(0, cpu.getState());
        cpu.execute();
        assertEquals(15, cpu.register);
        assertEquals(2, cpu.getTime());
        assertEquals(30, cpu.getState());
        cpu.addCommand(commands[1]);
        cpu.execute();
        assertEquals(15, cpu.register);
        assertEquals(3, cpu.getTime());
        assertEquals(45, cpu.getState());

    }

    @Test
    void executeTicksCorrectlyAOCExample1() {
        String input = "noop\n" +
                "addx 3\n" +
                "addx -5";

    String[] commandStrings = input.split("\n");
    CommandFactory factory = new CommandFactory();
    Command[] commands = factory.makeCommands(commandStrings);
    Clock clock = new Clock();
    PixelScreen screen = new PixelScreen(6, 40);
    Cpu cpu = new Cpu(clock, screen);
    cpu.addCommands(commands);
    assertEquals(1, cpu.register);
    cpu.execute();
    assertEquals(1, cpu.getTime());
    assertEquals(1, cpu.register);
    cpu.execute();
    assertEquals(2, cpu.getTime());
    assertEquals(1, cpu.register);
    cpu.execute();
    assertEquals(3, cpu.getTime());


    }
}