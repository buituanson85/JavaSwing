package JavaII.Lab2;

import java.io.File;
import java.io.IOException;

public class FileTree {
    public void read(String path, int count) throws IOException {
        File file = new File(path);
        String spaces = " ";
        for (int  i = 0; i < count; i++){
            spaces = spaces + " ";
        }

        //kiem tra file co ton tai hay ko
//        if (!file.exists()){
//            System.out.println("File not exists");
//            return;
//        }

        if (file.isDirectory()){
            String[] ls = file.list();
            for (File f : file.listFiles()){
                if (f.isDirectory()){
                    System.out.println(spaces + "+ folder: " + f.getName());
                    spaces += " ";
                    read(f.getAbsolutePath(),count + 1);
                    spaces = spaces.substring(0, spaces.length() - 1);
                }else {
                    System.out.println(spaces + "- file: " + f.getName());
                }
            }
        }else {
            System.out.println(spaces + "file: " + file.getName());
        }
    }
    public static void main(String[] args) {
//        String current = System.getProperty("user.dir");
        String current = "D:\\T2004E-JavaII\\src";
        File file = new File(current);
        try {
            System.out.println(file.getCanonicalPath());
            System.out.println("isFile: " + file.isFile());
            System.out.println("is Directory: " + file.isDirectory());
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileTree fileTree = new FileTree();

        try {
            fileTree.read(current, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
