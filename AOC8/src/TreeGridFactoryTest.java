import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreeGridFactoryTest {

    @org.junit.jupiter.api.Test
    void makeTreeGridMakesACorrectGridOfTrees() {
        String input = "30373\n" +
                "25512\n" +
                "65332\n" +
                "33549\n" +
                "35390\n";
        String[] strings = input.split("\n");
        ArrayList<String> inputStrings = new ArrayList<>(List.of(strings));
        TreeGridFactory factory = new TreeGridFactory();
        TreeGrid grid = factory.makeTreeGrid(inputStrings);

        assertEquals(3, grid.get(0, 0).getHeight());
        assertEquals(0, grid.get(grid.xLen() - 1, grid.yLen() - 1).getHeight());
        assertEquals(5, grid.xLen());
        assertEquals(5, grid.yLen());




    }
}