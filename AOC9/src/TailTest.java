import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TailTest {

    @Test
    public void isTouchingCorrectlyTriggers() {
        Head head = new Head(0, 0);
        Tail tail = new Tail(head);
        assertTrue(tail.isTouching());
        //right 1
        tail.move(1, 0);
        assertTrue(tail.isTouching());
        // up 1;
        tail.move(0, 1);
        assertTrue(tail.isTouching());
        // right 1
        tail.move(1, 0);
        assertFalse(tail.isTouching());
        //down 2
        tail.move(0, -2);
        assertFalse(tail.isTouching());
        //left 2
        tail.move(-2, 0);
        assertTrue(tail.isTouching());
    }

    @Test
    public void OnRowGetsWhenWeHaveMoved(){
        Head head = new Head(0, 0);
        Tail tail = new Tail(head);
        assertTrue(tail.onRow());
        tail.move(1, 0);
        assertTrue(tail.onRow());
        tail.move(0, 1);
        assertFalse(tail.onRow());
        tail.move(2, -1);
        assertTrue(tail.onRow());
    }

    @Test
    public void GetDiffXCorrectlyReturnsTheXDirection(){
        Head head = new Head(0, 0);
        Tail tail = new Tail(head);
        assertEquals(0, tail.getDiffX());
        tail.move(-1, 0);
        assertEquals(1, tail.getDiffX());
        tail.move(2, 0);
        assertEquals(-1, tail.getDiffX());
        tail.move(1, 0);
        assertEquals(-1, tail.getDiffX());
    }

    @Test
    public void followHeadCorrectlyFollowsHead(){
        Head head = new Head(0, 0);
        Tail tail = new Tail(head);
        head.move(1, 0);
        tail.followHead();
        assertEquals(0, tail.y);
        assertEquals(0, tail.x);
        head.move(1, 0);
        tail.followHead();
        assertEquals(0, tail.y);
        assertEquals(1, tail.x);
        head.move(0, 1);
        tail.followHead();
        assertEquals(0, tail.y);
        assertEquals(1, tail.x);
        head.move(1, 0);
        tail.followHead();
        assertEquals(1, tail.y);
        assertEquals(2, tail.x);

    }



}