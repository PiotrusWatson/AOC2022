package Packets;

public class Bit implements Packet{

    private int value;
    public Bit(int value){
        this.value = value;
    }

    public boolean isSmaller(Bit other){
        return this.value < other.value;
    }

    public boolean isDeepest(){
        return true;
    }

    public Packet goIn(){
        return this;
    }

    public int getSize(){
        return 1;
    }

    public String toString(){
        return String.valueOf(value);
    }
}
