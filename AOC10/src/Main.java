import Commands.Command;
import Commands.CommandFactory;
import java.util.Arrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("input.txt");
        try {
            ArrayList<String> strings = new ArrayList<>();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                strings.add(scanner.nextLine());
            }
            scanner.close();
            HashSet<Integer> possibleStrengths = new HashSet<>(Arrays.asList(20, 60, 100, 140, 180, 220));
            CommandFactory factory = new CommandFactory();
            Clock clock = new Clock();
            PixelScreen screen = new PixelScreen(6, 40);
            Cpu cpu = new Cpu(clock, screen);
            Command[] commands = factory.makeCommands(strings.toArray(new String[0]));
            cpu.addCommands(commands);
            int finalScore = 0;
            while (cpu.hasCommands()){
                cpu.execute();
                if (possibleStrengths.contains(cpu.getTime())){
                    finalScore += cpu.getState();
                }
            }

            System.out.println(finalScore);
            System.out.println(screen.toString());
        }
        catch (FileNotFoundException e){
            System.out.println(e + " Stopping...");
        }



    }
}