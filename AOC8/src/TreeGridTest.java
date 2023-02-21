import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreeGridTest {

    @Test
    void setEdgesVisible() {
        String input = "30373\n" +
                "25512\n" +
                "65332\n" +
                "33549\n" +
                "35390\n";
        String[] strings = input.split("\n");
        ArrayList<String> inputStrings = new ArrayList<>(List.of(strings));
        TreeGridFactory factory = new TreeGridFactory();
        TreeGrid grid = factory.makeTreeGrid(inputStrings);
        grid.setEdgesVisible();

        assertTrue(grid.isVisible(0, 0));
        assertTrue(grid.isVisible(grid.xLen() - 1, grid.yLen() - 1));
        assertFalse(grid.isVisible(1, 1));
    }
}