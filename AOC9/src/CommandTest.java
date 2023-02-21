import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    @Test
    void executeMovesTailToCorrectPlace() {
        Head head = new Head(0, 0);
        HashSet<Coord> seenBefore = new HashSet<>();
        Tail tail = new Tail(head);
        seenBefore.add(new Coord(0, 0));
        Coord right = new Coord(1, 0);
        Coord up = new Coord(0, 1);
        Command right4 = new Command(right, 4);
        int count = right4.execute(head, tail, seenBefore);
        assertEquals(4, head.x);
        assertEquals(0, head.y);
        assertEquals(3, tail.x);
        assertEquals(0, tail.y);
        assertEquals(3, count);
        Command up2 = new Command(up, 2);
        count = up2.execute(head, tail, seenBefore);
        assertEquals(4, head.x);
        assertEquals(2, head.y);
        assertEquals(4, tail.x);
        assertEquals(1, tail.y);
        assertEquals(1, count);
    }
}