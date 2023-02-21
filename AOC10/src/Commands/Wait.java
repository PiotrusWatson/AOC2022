package Commands;

public class Wait implements Command{
    public Wait(){
    }

    public boolean tick(){
        return true;
    }

    public int execute(){
        return 0;
    }
}
