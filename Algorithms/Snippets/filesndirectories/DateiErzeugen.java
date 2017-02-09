package filesndirectories;

import java.io.File;
import java.io.IOException;

public class DateiErzeugen {

    private boolean checkFile(File file) {
        if (file != null) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Error creating " + file.toString());
            }
            if (file.isFile() && file.canWrite() && file.canRead())
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        DateiErzeugen da = new DateiErzeugen();
        String dat = "test.txt";
        if(da.checkFile(new File(dat)))
            System.out.println(dat + " erzeugt");
    }
} 