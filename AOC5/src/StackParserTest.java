import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StackParserTest {
    @Test
    public void constructorSplitsTheCommandsFromTheCratesCorrectly(){
        String[] basicInputArray = {"[D]        \n",
                "[N] [C]    \n",
                "[Z] [M] [P]\n",
                " 1   2   3 \n",
                "\n",
                "move 1 from 2 to 1"};
        ArrayList<String> basicInput = new ArrayList<>(Arrays.asList(basicInputArray));
        StackParser parser = new StackParser(basicInput);
        assertEquals(parser.getCrateList()[0][0], "[D] ");
        assertEquals(parser.getCrateList()[1][0], "[N] ");
        assertEquals(parser.getCrateList()[2][0], "[Z] ");
        assertEquals(parser.getCrateList()[0][1], "    ");
        assertEquals(parser.getCrateList()[1][1], "[C] ");
        assertEquals(parser.getCrateList()[2][1], "[M] ");
        assertEquals(parser.getCrateList()[0][2], "   \n");
        assertEquals(parser.getCrateList()[1][2], "   \n");
        assertEquals(parser.getCrateList()[2][2], "[P]\n");

        assertEquals(parser.getCommandStrings().get(0), "move 1 from 2 to 1");
    }

    @Test
    public void constructorSplitsCrateListIntoExpectedNumberOfCrates(){
        String[] basicInputArray = {"[D]        \n",
                "[N] [C]    \n",
                "[Z] [M] [P]\n",
                " 1   2   3 \n",
                "\n",
                "move 1 from 2 to 1"};
        ArrayList<String> basicInput = new ArrayList<>(Arrays.asList(basicInputArray));
        StackParser parser = new StackParser(basicInput);
        assertEquals(parser.getCrateList()[0].length,3);
    }

    @Test
    public void constructorDoesNotTakeTheNumbers(){
        String[] basicInputArray = {"[D]        \n",
                "[N] [C]    \n",
                "[Z] [M] [P]\n",
                " 1   2   3 \n",
                "\n",
                "move 1 from 2 to 1"};
        ArrayList<String> basicInput = new ArrayList<>(Arrays.asList(basicInputArray));
        StackParser parser = new StackParser(basicInput);
        int size = parser.getCrateList().length;
        assertNotEquals(" 1  ", parser.getCrateList()[size - 1][0]);
    }

    @Test
    public void crateStacksBuildsWithCorrectData(){
        String[] basicInputArray = {"[D]        \n",
                "[N] [C]    \n",
                "[Z] [M] [P]\n",
                " 1   2   3 \n",
                "\n",
                "move 1 from 2 to 1"};
        ArrayList<String> basicInput = new ArrayList<>(Arrays.asList(basicInputArray));
        StackParser parser = new StackParser(basicInput);
        CrateStacks stacks = parser.buildCrateStacks();
        assertEquals(stacks.popFrom(0), new Crate(" D"));
        assertEquals(stacks.popFrom(0), new Crate(" N"));
        assertEquals(stacks.popFrom(0), new Crate(" Z"));
        assertEquals(stacks.popFrom(1), new Crate(" C"));
        assertEquals(stacks.popFrom(1), new Crate(" M"));
        assertEquals(stacks.popFrom(2), new Crate(" P"));

    }

}