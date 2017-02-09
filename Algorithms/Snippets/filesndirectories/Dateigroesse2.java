package filesndirectories;

import java.io.File;

public class Dateigroesse2 {

    public static void main(String[] args) {
        String dirName = "/";
        File dir = new File(dirName);
        if(!dir.exists()) {
            System.err.println(dir + " existiert nicht! - Abbruch");
            return;
        }
        long fileSize = readDir(dir, 0);
        System.out.println(fileSize / 1024d + "kb");
    }

    private static long calculateFileSize(File f) {
        if (!f.exists()) {
            return 0;
        }
        return f.length();
    }
    
    private static long readDir(File dir, long l) {
        System.out.println("reading directory " + dir.toString());
        File[] files = dir.listFiles();
        for(File f : files) {
            if(f.isDirectory()) {
                readDir(f, l);
            }else{
                long fSize = calculateFileSize(f);
                System.out.println("\t" + f.toString() + " -> " + fSize);
                l += fSize;
            }
        }
        return l;
    }
}