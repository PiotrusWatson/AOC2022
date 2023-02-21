import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VisibleTreeFinderTest {

    @Test
    public void seeTreesOnRowCorrectlySetsTrees(){
        String input = "30373\n" +
                "25512\n" +
                "65332\n" +
                "33549\n" +
                "35390\n";
        String[] strings = input.split("\n");
        ArrayList<String> inputStrings = new ArrayList<>(List.of(strings));
        TreeGridFactory factory = new TreeGridFactory();
        TreeGrid grid = factory.makeTreeGrid(inputStrings);
        VisibleTreeFinder finder = new VisibleTreeFinder(grid);

        finder.seeTreesOnRow(1);
        assertTrue(grid.isVisible(1, 1));
        assertFalse(grid.isVisible(1, 2));
        finder.seeTreesOnRow(2);
        assertFalse(grid.isVisible(2, 1));
    }


    @Test
    public void countTreesOnRowCorrectlyCountsTrees(){
        String input = "30373\n" +
                "25512\n" +
                "65332\n" +
                "33549\n" +
                "35390\n";
        String[] strings = input.split("\n");
        ArrayList<String> inputStrings = new ArrayList<>(List.of(strings));
        TreeGridFactory factory = new TreeGridFactory();
        TreeGrid grid = factory.makeTreeGrid(inputStrings);
        VisibleTreeFinder finder = new VisibleTreeFinder(grid);

        int count = finder.countTreesOnRowFromPosition(1, 2);
        assertEquals(2, count);
        count = finder.countTreesOnRowFromPosition(2, 1);
        assertEquals(3, count);
        count = finder.countTreesOnRowFromPosition(2, 4);
        assertEquals(0, count);
    }


    @Test
    public void seeTreesBackwardsOnRowCorrectlySetsTrees(){
        String input = "30373\n" +
                "25512\n" +
                "65332\n" +
                "33549\n" +
                "35390\n";
        String[] strings = input.split("\n");
        ArrayList<String> inputStrings = new ArrayList<>(List.of(strings));
        TreeGridFactory factory = new TreeGridFactory();
        TreeGrid grid = factory.makeTreeGrid(inputStrings);
        VisibleTreeFinder finder = new VisibleTreeFinder(grid);

        finder.seeTreesBackwardsOnRow(1);
        assertFalse(grid.isVisible(1, grid.xLen() - 2));
        assertTrue(grid.isVisible(1, grid.xLen() - 3));
    }

    @Test
    public void seeTreesOnColumnCorrectlySetsTrees() {
        String input = "30373\n" +
                "25512\n" +
                "65332\n" +
                "33549\n" +
                "35390\n";
        String[] strings = input.split("\n");
        ArrayList<String> inputStrings = new ArrayList<>(List.of(strings));
        TreeGridFactory factory = new TreeGridFactory();
        TreeGrid grid = factory.makeTreeGrid(inputStrings);
        VisibleTreeFinder finder = new VisibleTreeFinder(grid);

        finder.seeTreesOnColumn(1);
        assertTrue(grid.isVisible(1, 1));
        assertFalse(grid.isVisible(2, 1));
    }

    @Test
    public void seeTreesBackwardsOnColumnCorrectlySetsTrees() {
        String input = "30373\n" +
                "25512\n" +
                "65332\n" +
                "33549\n" +
                "35390\n";
        String[] strings = input.split("\n");
        ArrayList<String> inputStrings = new ArrayList<>(List.of(strings));
        TreeGridFactory factory = new TreeGridFactory();
        TreeGrid grid = factory.makeTreeGrid(inputStrings);
        VisibleTreeFinder finder = new VisibleTreeFinder(grid);

        finder.seeTreesBackwardsOnColumn(1);
        assertFalse(grid.isVisible(grid.yLen() - 2, 1));
        assertFalse(grid.isVisible(grid.yLen() - 3, 1));
        finder.seeTreesBackwardsOnColumn(2);
        assertTrue(grid.isVisible(grid.yLen() - 2, 2));
        assertFalse(grid.isVisible(grid.yLen() - 3, 2));
    }

    @Test
    public void seeAllVisibleTreesSetsTreesCorrectly() {
        String input = "30373\n" +
                "25512\n" +
                "65332\n" +
                "33549\n" +
                "35390\n";
        String[] strings = input.split("\n");
        ArrayList<String> inputStrings = new ArrayList<>(List.of(strings));
        TreeGridFactory factory = new TreeGridFactory();
        TreeGrid grid = factory.makeTreeGrid(inputStrings);
        VisibleTreeFinder finder = new VisibleTreeFinder(grid);

        finder.seeAllVisibleTrees();
        assertTrue(grid.isVisible(1, 1));
        assertTrue(grid.isVisible(1, 2));
        assertTrue(grid.isVisible(2, 1));
        assertFalse(grid.isVisible(2, 2));
        assertTrue(grid.isVisible(2, 3));
        assertFalse(grid.isVisible(3, 1));
        assertTrue(grid.isVisible(3, 2));
    }

    @Test
    public void countAllVisibleTreesCountsProperly() {
        String input = "30373\n" +
                "25512\n" +
                "65332\n" +
                "33549\n" +
                "35390\n";
        String[] strings = input.split("\n");
        ArrayList<String> inputStrings = new ArrayList<>(List.of(strings));
        TreeGridFactory factory = new TreeGridFactory();
        TreeGrid grid = factory.makeTreeGrid(inputStrings);
        VisibleTreeFinder finder = new VisibleTreeFinder(grid);

        assertEquals(finder.countVisibleTrees(), 16);
        finder.seeAllVisibleTrees();
        assertEquals(finder.countVisibleTrees(), 21);
    }
}