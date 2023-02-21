import java.util.ArrayList;

public class TreeGridFactory {

    public TreeGrid makeTreeGrid(ArrayList<String> heightNumbers){
        int xLen = heightNumbers.get(0).length();
        int yLen = heightNumbers.size();
        Tree[][] grid = new Tree[yLen][xLen];
        for (int i = 0; i < yLen; i++){
            for (int j = 0; j < xLen; j++){
                int value = Character.getNumericValue(heightNumbers.get(i).charAt(j));
                grid[i][j] = new Tree(value);
            }
        }
        return new TreeGrid(grid);
    }
}
