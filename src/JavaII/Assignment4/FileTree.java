package JavaII.Assignment4;

import java.io.File;
import java.io.IOException;

public class FileTree {
    String spaces = " ";
    public void read(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()){
            System.out.println("File not exists");
            return;
        }
        if (file.isDirectory()){
            String[] ls = file.list();
            for (File f : file.listFiles()){
                if (f.isDirectory()){
                    System.out.println(spaces + "+ Path: " + f.getName());
                    spaces += " ";
                    read(f.getAbsolutePath());
                    spaces = spaces.substring(0, spaces.length() - 1);
                }else {
                    System.out.println(spaces + "- Child: " + f.getName());
                }
            }
        }else {
            System.out.println(spaces + "- Child: " + file.getName());
        }
    }
    public static void main(String[] args){
//        String current = System.getProperty("user.dir");
        String current = "D:\\T2004E-JavaII\\src";
        FileTree fileTree = new FileTree();
        try {
            fileTree.read(current);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        File file = new File(current);
//        try {
//            System.out.println(file.getCanonicalPath());
//            System.out.println("isFile: " + file.isFile());
//            System.out.println("is Directory: " + file.isDirectory());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
