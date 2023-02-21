public class Clock {
    int time;

    public Clock(){
        time = 1;
    }

    public void tick(){
        time += 1;
    }

    public int getTime(){
        return time;
    }
}
