package Java2.File;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileAndFileOutStream {
    public static void main(String[] args) throws IOException {
        // phần 1: file class
        File file = new File("son.txt");
        if (file.exists()){
            System.out.println("file tồn tại");
        }else {
            try {
                file.createNewFile();
            }catch (IOException ex){
                Logger.getLogger(FileAndFileOutStream.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("file not found");
        }
        // phần 2 cách ghi dữ liệu vào file
        FileOutputStream fileOutputStream = null;
        Scanner sc = new Scanner(System.in);
        try{
            fileOutputStream = new FileOutputStream("test.txt");

//            String line = "Bùi Tuấn Sơn";
//            byte[] b = line.getBytes();
//            fileOutputStream.write(b);
            for ( ; ; ){
                System.out.println("Insert line into file");
                String line = sc.nextLine() + "\n";  // "\n" ký tự xuống dòng
                byte[] b = line.getBytes();

                fileOutputStream.write(b);
                System.out.println("Continue Y/N");
                String choose = sc.nextLine();

                if (choose.equalsIgnoreCase("N")){
                    break;
                }
            }

        }catch (FileNotFoundException ex){
            Logger.getLogger(FileAndFileOutStream.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex){
            Logger.getLogger(FileAndFileOutStream.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileOutputStream.close();
            }catch (IOException ex){
                Logger.getLogger(FileAndFileOutStream.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
