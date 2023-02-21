import java.util.HashSet;

public class PositionCounter {

    Head head;
    Tail tail;

    Rope rope;

    Command[] commands;
    int count;
    HashSet<Coord> seenBefore;

    public PositionCounter(Head head, Tail tail, Command[] commands){
        this.head = head;
        this.tail = tail;
        this.commands = commands;
        count = 1;
        seenBefore = new HashSet<Coord>();
        seenBefore.add(tail.getPosition());
    }
    public PositionCounter(Rope rope, Command[] commands){
        this.rope = rope;
        this.commands = commands;
        count = 1;
        seenBefore = new HashSet<Coord>();
        seenBefore.add(rope.getPosition());
    }


    public void executeAll(){
        for (Command command: commands){
            execute(command);
        }
    }

    public void execute(Command command){
        if (rope != null){
            count += command.execute(rope, seenBefore);
        } else{
            count += command.execute(head, tail, seenBefore);
        }


    }

    public int getCount(){
        return count;
    }

}
