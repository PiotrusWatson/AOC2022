public class Head implements Knot {
    int x;
    int y;

    public Head(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void move(int byX, int byY){
        this.x += byX;
        this.y += byY;
    }

    public Coord getPosition(){
        return new Coord(x, y);
    }

}
