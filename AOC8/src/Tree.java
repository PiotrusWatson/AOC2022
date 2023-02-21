public class Tree {
    private int height;
    private boolean isVisible;

    public Tree(int height){
        this.height = height;
        isVisible = false;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public int getHeight() {
        return height;
    }
}
