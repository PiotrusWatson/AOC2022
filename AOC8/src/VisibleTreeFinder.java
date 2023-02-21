public class VisibleTreeFinder {
    TreeGrid grid;
    public VisibleTreeFinder(TreeGrid grid){
        this.grid = grid;
        this.grid.setEdgesVisible();
    }

    public int getLargestScenicScore(){
        int score = 0;
        for (int i = 0; i < grid.yLen(); i++){
            for (int j = 0; j < grid.yLen(); j++){
                int up = countTreesBackOnColumnFromPosition(i, j);
                int down = countTreesOnColumnFromPosition(i, j);
                int left = countTreesBackOnRowFromPosition(i, j);
                int right = countTreesOnRowFromPosition(i, j);
                int newScore = up * down * left * right;
                if (newScore > score){
                    score = newScore;
                }
            }
        }
        return score;
    }
    public int countTreesOnColumnFromPosition(int startRow, int column){
        int startingPoint = grid.get(startRow, column).getHeight();
        int count = 0;
        for (int i = startRow + 1; i < grid.yLen(); i++){
            count += 1;
            Tree got = grid.get(i, column);
            if (got.getHeight() >= startingPoint){
                return count;
            }
        }
        return count;
    }

    public int countTreesBackOnColumnFromPosition(int startRow, int column){
        int startingPoint = grid.get(startRow, column).getHeight();
        int count = 0;
        for (int i = startRow - 1; i >= 0; i--){
            count += 1;
            Tree got = grid.get(i, column);
            if (got.getHeight() >= startingPoint){
                return count;
            }
        }
        return count;
    }

    public int countTreesOnRowFromPosition(int row, int startColumn){
        int startingPoint = grid.get(row, startColumn).getHeight();
        int count = 0;
        for (int i = startColumn + 1; i < grid.xLen(); i++){
            count += 1;
            Tree got = grid.get(row, i);
            if (got.getHeight() >= startingPoint){
                return count;
            }
        }
        return count;
    }

    public int countTreesBackOnRowFromPosition(int row, int startColumn){
        int startingPoint = grid.get(row, startColumn).getHeight();
        int count = 0;
        for (int i = startColumn - 1; i >= 0; i--){
            count += 1;
            Tree got = grid.get(row, i);
            if (got.getHeight() >= startingPoint){
                return count;
            }
        }
        return count;
    }
    public void seeTreesOnRow(int row){
        int lastHeight = grid.get(row, 0).getHeight();
        for (int i = 1; i < grid.xLen() - 1; i++){
            Tree got = grid.get(row, i);
            if (got.getHeight() > lastHeight) {
                got.setVisible(true);
                lastHeight = got.getHeight();
            }
        }
    }

    public void seeTreesBackwardsOnRow(int row){
        int lastHeight = grid.get(row, grid.xLen() - 1).getHeight();
        for (int i = grid.xLen() - 2; i >= 1; i--){
            Tree got = grid.get(row, i);
            if (got.getHeight() > lastHeight){
                got.setVisible(true);
                lastHeight = got.getHeight();
            }
        }
    }

    public void seeTreesOnColumn(int column){
        int lastHeight = grid.get(0, column).getHeight();
        for (int i = 0; i < grid.yLen() - 1; i++){
            Tree got = grid.get(i, column);
            if (got.getHeight() > lastHeight){
                got.setVisible(true);
                lastHeight = got.getHeight();
            }
        }
    }

    public void seeTreesBackwardsOnColumn(int column){
        int lastHeight = grid.get(grid.yLen() - 1, column).getHeight();
        for (int i = grid.yLen() - 2; i >= 1; i--){
            Tree got = grid.get(i, column);
            if (got.getHeight() > lastHeight){
                got.setVisible(true);
                lastHeight = got.getHeight();
            }
        }
    }

    public void seeAllVisibleTrees(){
        for (int row = 1; row < grid.xLen() - 1; row++){
            seeTreesOnRow(row);
            seeTreesBackwardsOnRow(row);
        }

        for (int column = 1; column < grid.yLen() - 1; column++){
            seeTreesOnColumn(column);
            seeTreesBackwardsOnColumn(column);
        }
    }

    public int countVisibleTrees(){
        int total = 0;
        for (int i = 0; i < grid.yLen(); i++) {
            for (int j = 0; j < grid.xLen(); j++) {
                if (grid.isVisible(i, j)) {
                    total += 1;
                }
            }
        }
        return total;
    }


}
