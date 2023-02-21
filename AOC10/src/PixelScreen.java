public class PixelScreen {
    PixelRow[] screen;
    int width;
    int height;
    public PixelScreen(int height, int width){
        this.width = width;
        this.height = height;
        screen = new PixelRow[height];
        for (int i = 0; i < height; i++){
            screen[i] = new PixelRow(width);
        }
    }

    public int[] boundFromIndex(int index){
        if (index < width){
            return new int[]{0, index};
        }
        return new int[]{index / width, index % width};
    }

    public void drawAtTimeFromMemory(int time, PixelRow memory){
        int[] bound = boundFromIndex(time);
        int row = bound[0];
        int column = bound[1];
        PixelRow toDraw = screen[row];
        toDraw.drawFromMemoryAtIndex(memory, column);
    }
    public String toString(){
        StringBuilder output = new StringBuilder();
        for (PixelRow row : screen){
            output.append(row.toString() + "\n");
        }
        return output.toString();
    }
}
