import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class BufferWindowTest {



    @org.junit.jupiter.api.Test
    void fillUpToLimitFillsOnlyUpToLimit() {
        BufferWindow buffer = new BufferWindow(4);
        String inputRepeating = "abcbacba1234";

         buffer.fillUpToLimit(inputRepeating);
         assertEquals("[a, b, c, b]", buffer.toString());

    }

    @org.junit.jupiter.api.Test
    void cycleCyclesThrough() {
        BufferWindow buffer = new BufferWindow(4);
        String inputRepeating = "abcbacba1234";

        buffer.fillUpToLimit(inputRepeating);
        buffer.cycle(inputRepeating.charAt(4));
        assertEquals("[b, c, b, a]", buffer.toString());
    }

    @org.junit.jupiter.api.Test
    void areCharactersRepeatedWorks() {
        BufferWindow buffer = new BufferWindow(4);
        String inputRepeating = "abcbacba1234";

        buffer.fillUpToLimit(inputRepeating);
        assertEquals(true, buffer.areCharactersRepeated());
        for (int i = 4; i < inputRepeating.length(); i++){
            buffer.cycle(inputRepeating.charAt(i));
        }
        assertEquals(false, buffer.areCharactersRepeated());

    }
}