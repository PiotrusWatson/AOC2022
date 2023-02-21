public class Tail implements Knot{

    int x;
    int y;
    Knot head;
    public Tail(Knot head){
        this.x = head.getPosition().x;
        this.y = head.getPosition().y;
        this.head = head;
    }

    public boolean isTouching(){
        return Math.abs(head.getPosition().x - x) <= 1 && Math.abs(head.getPosition().y - y) <= 1;
    }

    public boolean onColumn(){
        return x == head.getPosition().x;
    }

    public boolean onRow(){
        return y == head.getPosition().y;
    }

    public void move(int newX, int newY){
        x += newX;
        y += newY;
    }

    public void followHead(){
        if (isTouching()){
            return;
        }

        if (!onColumn() && !onRow()){
            move(getDiffX(), getDiffY());
        }
        else if (!onColumn()){
            move(getDiffX(), 0);
        }
        else if (!onRow()){
            move(0, getDiffY());
        }
    }

    public int getDiffX(){
        return Integer.signum(head.getPosition().x - x);
    }

    public int getDiffY(){
        return Integer.signum(head.getPosition().y - y);
    }

    public Coord getPosition(){
        return new Coord(x, y);
    }

}
