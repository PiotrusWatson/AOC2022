import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CrateStacksTest {

    @Test
    void testToString() {
        String[] basicInputArray = {"[D]        \n",
                "[N] [C]    \n",
                "[Z] [M] [P]\n",
                " 1   2   3 \n",
                "\n",
                "move 1 from 2 to 1"};
        ArrayList<String> basicInput = new ArrayList<>(Arrays.asList(basicInputArray));
        StackParser parser = new StackParser(basicInput);
        CrateStacks stacks = parser.buildCrateStacks();
        assertEquals("DCP", stacks.toString());
    }

    @Test
    void testToStringWithSomeCommands() {
        String[] basicInputArray = {"[D]        \n",
                "[N] [C]    \n",
                "[Z] [M] [P]\n",
                " 1   2   3 \n",
                "\n",
                "move 1 from 2 to 1"};
        ArrayList<String> basicInput = new ArrayList<>(Arrays.asList(basicInputArray));
        StackParser parser = new StackParser(basicInput);
        CrateStacks stacks = parser.buildCrateStacks();
        Executor executor = new Executor(parser.buildCommandList(), stacks);
        executor.executeAll();
        assertEquals("CMP", stacks.toString());
    }


}