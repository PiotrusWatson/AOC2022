public class Crate {
    char contents;
    public Crate(String input){
        contents = input.charAt(1);
    }

    public char getContents(){
        return contents;
    }

    public boolean equals(Object other){
        if (other == null){
            return false;
        }
        if (!(other instanceof Crate)){
            return false;
        }
        Crate otherCrate = (Crate) other;

        return contents == otherCrate.contents;
    }

    @Override
    public String toString(){
        return String.valueOf(contents);
    }
}
