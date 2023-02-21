import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("input.txt");
        try {
            Scanner scanner = new Scanner(file);
            ArrayList<String> commandStrings = new ArrayList<String>();
            while (scanner.hasNextLine()){
                commandStrings.add(scanner.nextLine());
            }
            scanner.close();
            CommandParser parser = new CommandParser();
            Command[] commands = parser.parseAll(commandStrings.toArray(new String[0]));
            Head head = new Head(0, 0);
            Tail tail = new Tail(head);
            Rope rope = new Rope(9);
            PositionCounter counter = new PositionCounter(rope, commands);
            counter.executeAll();
            System.out.println(counter.getCount());


        }
        catch (FileNotFoundException e){
            System.out.println(e + " Stopping...");
        }
        catch (Exception e){
            System.out.println(e + " Stopping...");
        }


    }
}