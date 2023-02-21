public class Command {
    public int getAmountToPop() {
        return amountToPop;
    }

    public int getFromIndex() {
        return fromIndex;
    }

    public int getToIndex() {
        return toIndex;
    }

    int amountToPop;
    int fromIndex;
    int toIndex;

    //some horsehsit regex
    public Command(String input){
        String[] splitInput = input.split(" ");
        amountToPop = Integer.valueOf(splitInput[1].replaceAll("\\s+",""));
        fromIndex = Integer.valueOf(splitInput[3].replaceAll("\\s+","")) - 1;
        toIndex = Integer.valueOf(splitInput[5].replaceAll("\\s+","")) - 1;
    }
}
