import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("input.txt");
        ArrayList<String> inputStrings = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                inputStrings.add(scanner.nextLine());
            }
            scanner.close();
            TreeGridFactory factory = new TreeGridFactory();
            TreeGrid grid = factory.makeTreeGrid(inputStrings);
            VisibleTreeFinder finder = new VisibleTreeFinder(grid);
            finder.seeAllVisibleTrees();
            System.out.println(finder.countVisibleTrees());
            System.out.println(finder.getLargestScenicScore());
        } catch (FileNotFoundException e){
            System.out.println(e + " Stopping...");
        }


    }
}