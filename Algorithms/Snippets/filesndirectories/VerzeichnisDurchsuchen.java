package filesndirectories;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class VerzeichnisDurchsuchen {

    public static void main(String[] args) {
        String verzName = "/Users/joecze/Desktop/test/";
        ArrayList<File> files = getPaths(new File(verzName),
                new ArrayList<File>());
        if(files == null) return;
        try {
            for (int i = 0; i < files.size(); i++)
                System.out.println(files.get(i).getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<File> getPaths(File file, ArrayList<File> list) {
        if (file == null || list == null || !file.isDirectory())
            return null;
        File[] fileArr = file.listFiles();
        for (File f : fileArr) {
            if (f.isDirectory()) {
                getPaths(f, list);
            }
            list.add(f);
        }
        return list;
    }
} 