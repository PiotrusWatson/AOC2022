import Commands.Command;

import java.util.LinkedList;
import java.util.Queue;

public class Cpu {
    Clock clock;
    int register;

    PixelScreen screen;
    PixelRow memory;
    Queue<Command> commandQueue;
    public Cpu(Clock clock, PixelScreen screen){
        this.clock = clock;
        this.register = 1;
        commandQueue = new LinkedList<Command>();
        memory = new PixelRow(screen.width);
        this.screen = screen;

    }

    public void addCommand(Command command){
        commandQueue.add(command);
    }

    public void addCommands(Command[] commands){
        for (Command command : commands){
            addCommand(command);
        }
    }

    public void execute(){
        clock.tick();
        screen.drawAtTimeFromMemory(clock.getTime() - 2, memory);
        Command command = commandQueue.peek();
        if (command.tick()){
            register += commandQueue.remove().execute();
            memory.drawOnce(register);
        }

    }

    public int getTime(){
        return clock.getTime();
    }

    public int getState(){
        return getTime() * register;
    }

    public boolean hasCommands(){
        return !commandQueue.isEmpty();
    }



}
