import java.io.File;
import java.io.FileNotFoundException;
import java.nio.Buffer;
import java.util.Scanner;

public class Main {

    public static int getCountBeforeNoRepetition(BufferWindow buffer, String input) {
        for (int i = 14; i < input.length(); i++) {
            if (!buffer.areCharactersRepeated()) {
                return buffer.getCount();
            }
            buffer.cycle(input.charAt(i));

        }
        return -1;
    }

    public static void main(String[] args) {
        File file = new File("input");
        try {
            StringBuilder builder = new StringBuilder();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()){
                builder.append(scanner.next());
            }
            scanner.close();

            BufferWindow buffer = new BufferWindow( 14);
            String input = builder.toString();
            buffer.fillUpToLimit(input);
            int count = getCountBeforeNoRepetition(buffer, input);
            System.out.println(count);



        }
        catch (FileNotFoundException e){
            System.out.println("oops! no files");
        }

    }
}