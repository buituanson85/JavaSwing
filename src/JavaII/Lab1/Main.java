package JavaII.Lab1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileInputStream inObj = null;
        FileOutputStream outObj = null;
        try {
            inObj = new FileInputStream("D:\\T2004E-JavaII\\hello.txt");
            outObj = new FileOutputStream("D:\\T2004E-JavaII\\hello2.txt");
                    int ch;
                    while ((ch = inObj.read()) != -1){
                        outObj.write(ch);
                    }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inObj != null){
                try {
                    inObj.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outObj != null){
                try {
                    outObj.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
