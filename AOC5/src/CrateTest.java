import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrateTest {
    @Test
    public void crateConstructorTakesInputCorrectly(){
        String input = "[A] ";
        Crate crate = new Crate(input);
        assertEquals('A', crate.getContents());
    }

    @Test
    public void crateToStringWorks(){
        String input = "[A] ";
        Crate crate = new Crate(input);
        assertEquals("A", crate.toString());
    }
}