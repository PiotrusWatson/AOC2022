package Packets;

import java.util.ArrayList;

public class PacketFactory {
    public Packet makePacket(String input){
        ArrayList<Packet> bits = new ArrayList<>();
        Packet newBit = null;
        String[] commaSeparated = input.split(",");
        for (String item : commaSeparated){
            if (item.startsWith("[")){
                String trimmedItem = item.substring(1, item.length() - 1);
                newBit = makePacket(trimmedItem);
            }
            else {
                newBit = makeBit(input);
            }
            bits.add(newBit);
        }
        return new BitList(bits.toArray(new Packet[0]));

    }

    public Packet makePacketFromBase(String input){
        return makePacket(input.substring(1, input.length()-1));
    }


    public Bit makeBit(String input){
        return new Bit(Integer.valueOf(input));
    }
}
