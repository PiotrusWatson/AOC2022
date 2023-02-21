package Commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddTest {

    @Test
    void tick() {
        Add adder = new Add(15);
        assertFalse(adder.tick());
        assertTrue(adder.tick());
    }
}