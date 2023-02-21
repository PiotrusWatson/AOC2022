package Packets;

public class BitList implements Packet {
    Packet[] bits;
    int index;


    public BitList(Packet[] bits){
        this.bits = bits;
        this.index = 0;
    }

    public Packet goIn(){
        return bits[index];
    }

    public Packet getNext(){
        index += 1;
        return bits[index];
    }

    public boolean isDeepest(){
        return false;
    }

    public int getSize(){
        return bits.length;
    }


}
