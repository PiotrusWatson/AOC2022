package Packets;

import static org.junit.jupiter.api.Assertions.*;

class PacketFactoryTest {

    @org.junit.jupiter.api.Test
    void makePacketCorrectlyMakesPackets() {
        PacketFactory factory = new PacketFactory();
        String input = "[1,1,3,1,1]";
        Packet answer = factory.makePacketFromBase(input);
        assertEquals(5, answer.getSize());
        assertEquals("1", answer.goIn().toString());
    }
}