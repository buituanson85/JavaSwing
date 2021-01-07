package Java2.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadFile {
    //đọc du liệu theo từ
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("test.txt");

//           int code = fileInputStream.read();
//           char c = (char) code;
//            System.out.println("c>>" + c);
            StringBuilder stringBuilder = new StringBuilder();

            int code;
            while ((code = fileInputStream.read()) != -1){
//                char c = (char) code;
//                System.out.print(c);
                stringBuilder.append((char) code);
            }
            String conten = stringBuilder.toString();
            System.out.println(conten);

        } catch (FileNotFoundException ex) {
//            ex.printStackTrace();
            Logger.getLogger(FileAndFileOutStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //            ex.printStackTrace();
            Logger.getLogger(FileAndFileOutStream.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
               try {
                   fileInputStream.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
        }
}
