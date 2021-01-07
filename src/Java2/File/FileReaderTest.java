package Java2.File;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileReaderTest {
    //đọc dữ liệu theo dòng
    public static void main(String[] args) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("test.txt");
            bufferedReader = new BufferedReader(fileReader);

//            String line = bufferedReader.readLine();

//            System.out.println(line);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileAndFileOutStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileAndFileOutStream.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileReader.close();
            } catch (IOException ex) {
                Logger.getLogger(FileAndFileOutStream.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    Logger.getLogger(FileAndFileOutStream.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
}
