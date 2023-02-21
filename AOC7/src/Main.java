import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    File file = new File("input.txt");
    try {
        StringBuilder inputString = new StringBuilder();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            inputString.append(scanner.nextLine() + "\n");
        }
        scanner.close();
        CommandExecutorBuilder builder = new CommandExecutorBuilder();
        CommandExecutor executor = builder.buildCommandExecutor(inputString.toString());
        executor.executeAll();
        FileTree tree = executor.fileTree;
        FolderCollector collector = new FolderCollector(tree, 100000, 4274331);

        collector.collectFolders();
        System.out.println(70000000 - tree.root.getSize());
        long total = collector.sumFolders();
        long smallest = collector.smallestItem();
        System.out.println(total);
        System.out.println(smallest);

    }
    catch (FileNotFoundException e){
        System.out.println("File not found! Stopping...");
    }




    }
}