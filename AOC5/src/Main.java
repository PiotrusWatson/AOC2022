import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File file = new File("input.txt");
        try {
            ArrayList<String> commandStrings = new ArrayList<>();
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()){
                commandStrings.add(fileScanner.nextLine());
            }
            fileScanner.close();

            StackParser parser = new StackParser(commandStrings);
            CrateStacks stacks = parser.buildCrateStacks();
            Executor executor = new Executor(parser.buildCommandList(), stacks);
            executor.executeAllInOrder();
            System.out.println("HERE ARE SOME STUFF: " + stacks.toString());
        }
        catch (FileNotFoundException e){
            System.out.println("No file! Stopping...");

        }



    }
}