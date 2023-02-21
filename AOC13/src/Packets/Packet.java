package Packets;

public interface Packet {
    boolean isDeepest();
    Packet goIn();
    int getSize();
}
