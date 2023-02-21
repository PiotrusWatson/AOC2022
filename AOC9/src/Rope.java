public class Rope {

    Head head;
    Tail[] tails;
    public Rope(int size){
        head = new Head(0, 0);
        tails = new Tail[size];
        Knot knot = head;
        for (int i = 0; i < size; i++){
            tails[i] = new Tail(knot);
            knot = tails[i];
        }
    }

    public void move(int x, int y){
        head.move(x, y);
        for (Tail tail: tails){
            tail.followHead();
        }
    }

    public Coord getPosition(){
        return tails[tails.length - 1].getPosition();
    }
}
