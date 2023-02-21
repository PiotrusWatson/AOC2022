import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PixelScreenTest {

    @Test
    void boundFromIndexGetsCorrectBoundsFromAnIndex() {
        PixelScreen screen = new PixelScreen(6, 40);
        int[] bound = screen.boundFromIndex(30);
        assertEquals(0, bound[0]);
        assertEquals(30, bound[1]);
        bound = screen.boundFromIndex(40);
        assertEquals(1, bound[0]);
        assertEquals(0, bound[1]);
        bound = screen.boundFromIndex(201);
        assertEquals(bound[0], 5);
        assertEquals(bound[1], 1);
        bound = screen.boundFromIndex(239);
        assertEquals(bound[0], 5);
        assertEquals(bound[1], 39);
    }

}