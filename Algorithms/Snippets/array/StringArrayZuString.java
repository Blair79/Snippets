package array;

public class StringArrayZuString {

    public static void main(String[] args) {
        String[] strings = {"Ene", "mene", "Maus", "und", "du", "bist", "raus"};
        StringBuilder builder = new StringBuilder();
        for(String s : strings) {
            builder.append(s + System.getProperty("line.separator"));
        }
        System.out.println(builder.toString());
    }
} 