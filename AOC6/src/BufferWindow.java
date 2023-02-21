import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
public class BufferWindow {
    Queue<Character> buffer;
    int size;
    int count;

    public int getCount() {
        return count;
    }

    public BufferWindow(int size){
        buffer = new LinkedList<Character>();
        this.size = size;
        this.count = 0;
    }

    public void fillUpToLimit(String input){
        for (int i = 0; i < size; i++){
            buffer.add(input.charAt(i));
            count += 1;
        }
    }

    public String toString(){
        return buffer.toString();
    }

    public void cycle(char newCharacter){
        buffer.remove();
        buffer.add(newCharacter);
        count += 1;
    }

    public boolean areCharactersRepeated(){
        int i = 0;
        for (char item: buffer){
            int j = 0;
            for (char otherItem: buffer){
                if (j == i){
                    continue;
                }
                if (item == otherItem){
                    return true;
                }
                j += 1;
            }
            i += 1;
        }
        return false;
    }

}
