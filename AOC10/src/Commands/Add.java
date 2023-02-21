package Commands;

public class Add implements Command {
    int amount;
    int waitTime;
    int ticker;
    public Add(int amount){
        this.amount = amount;
        waitTime = 2;
        ticker = 0;
    }

    public boolean tick(){
        ticker += 1;
        if (ticker < waitTime){
            return false;
        }
        return true;
    }

    public int execute(){
        return amount;
    }



}
