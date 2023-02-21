import java.util.HashSet;

public class Command {
    Coord coord;
    int iterations;
    public Command(Coord coord, int iterations){
        this.coord = coord;
        this.iterations = iterations;
    }

    public int execute(Head head, Tail tail, HashSet<Coord> seenBefore){
        int count = 0;
        for (int i = 0; i < this.iterations; i++){
            head.move(coord.x, coord.y);
            tail.followHead();
            if (!seenBefore.contains(tail.getPosition())){
                count += 1;
                seenBefore.add(tail.getPosition());
            }
        }
        return count;
    }

    public int execute(Rope rope, HashSet<Coord> seenBefore){
        int count = 0;
        for (int i = 0; i < iterations; i++){
            rope.move(coord.x, coord.y);
            if (!seenBefore.contains(rope.getPosition())){
                count += 1;
                seenBefore.add(rope.getPosition());
            }
        }
        return count;
    }
}
