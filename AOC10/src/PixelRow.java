public class PixelRow {
    Pixel[] row;
    public PixelRow(int size){
        row = new Pixel[size];
        for (int i = 0; i < row.length; i++){
            row[i] = Pixel.NOT_DONE;
        }
    }

    public Pixel get(int index){
        return row[index];
    }

    public Pixel compareAtIndex(PixelRow other, int index){
        if (other.get(index) == Pixel.NOT_DONE || other.get(index) == Pixel.ERROR){
            return Pixel.ERROR;
        }
        return other.get(index);
    }

    public void drawFromMemoryAtIndex(PixelRow memory, int index){
        Pixel newPixel = compareAtIndex(memory, index);
        row[index] = newPixel;
    }


    public void drawOnce(int position){
        for (int i = 0; i < row.length; i++){
            if (i == position || i == position - 1 || i == position + 1){
                row[i] = Pixel.ON;
            }
            else {
                row[i] = Pixel.OFF;
            }
        }
    }

    public String toString(){
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < row.length; i++){
            switch (row[i]){
                case ON:
                    output.append("#");
                    break;
                case OFF:
                    output.append(".");
                    break;
                case NOT_DONE:
                    output.append("_");
                    break;
                default:
                    output.append("?");
            }
        }
        return output.toString();
    }
}
