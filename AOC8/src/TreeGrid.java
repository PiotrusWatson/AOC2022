public class TreeGrid {
    Tree[][] grid;

    public TreeGrid(Tree[][] grid){
        this.grid = grid;
    }

    public Tree get(int x, int y){
        return grid[x][y];
    }

    public void makeVisible(int x, int y){
        grid[x][y].setVisible(true);
    }
    public boolean isVisible(int x, int y){
        return grid[x][y].isVisible();
    }

    public void setEdgesVisible(){
        for (int i = 0; i < xLen(); i++){
            grid[0][i].setVisible(true);
            grid[yLen() - 1][i].setVisible(true);
        }
        for (int i = 0; i < yLen(); i++){
            grid[i][0].setVisible(true);
            grid[i][xLen() - 1].setVisible(true);
        }
    }

    public int yLen(){
        return grid.length;
    }

    public int xLen(){
        return grid[0].length;
    }




}
