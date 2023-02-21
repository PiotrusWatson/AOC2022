import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PixelRowTest {

    @Test
    void drawOncePutsCorrectPositionsToScreen() {
        PixelRow row = new PixelRow(40);
        row.drawOnce(1);
        assertEquals("###.....................................", row.toString());
        row.drawOnce(16);
        assertEquals("...............###......................", row.toString());
        row.drawOnce(5);
        assertEquals("....###.................................", row.toString());

    }

    @Test
    void compareToCorrectlyGetsPixel(){
        PixelRow row = new PixelRow(40);
        PixelRow other = new PixelRow(40);
        other.drawOnce(1);
        Pixel result = row.compareAtIndex(other, 0);
        assertEquals(Pixel.ON, result);
        result = row.compareAtIndex(other, 1);
        assertEquals(Pixel.ON, result);
        other.drawOnce(16);
        result = row.compareAtIndex(other, 2);
        assertEquals(Pixel.OFF, result);
    }

    @Test
    void drawFromMemoryAtIndexDrawsSomethingCorrect(){
        PixelRow row = new PixelRow(40);
        PixelRow other = new PixelRow(40);
        other.drawOnce(1);
        row.drawFromMemoryAtIndex(other, 0);
        assertEquals("#_______________________________________", row.toString());
        row.drawFromMemoryAtIndex(other, 1);
        assertEquals("##______________________________________", row.toString());
        other.drawOnce(16);
        row.drawFromMemoryAtIndex(other, 2);
        assertEquals("##._____________________________________", row.toString());
    }
}