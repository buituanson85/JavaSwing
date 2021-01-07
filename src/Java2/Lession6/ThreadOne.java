package Java2.Lession6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ThreadOne extends Thread {
    //đọc dữ liệu từ file student.txt
    SharedData sharedData;
    FileReader reader = null;
    BufferedReader bufferedReader = null;
    public ThreadOne(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            reader = new FileReader("D:\\T2004E-JavaII\\src\\Java2\\Lession6\\Student.txt");
            bufferedReader = new BufferedReader(reader);

            String line = null;
            //đọc từng dòng
            while (sharedData.isAlive()){
                line = bufferedReader.readLine();
                if (line == null){
                    sharedData.setAlive(false);
                    break;
                }
                // đồng bộ dự liệu từ đây
                synchronized (sharedData){
                    boolean isValidate = Student.checkValidateRollNo(line);
                    if (isValidate){
                        Student student = new Student(line);
                        sharedData.getValidRollNumber().add(student);
                        sharedData.setCurrentThread(SharedData.THREAD_2);
                    }else {
                        sharedData.getUnvalidRollNumber().add(line);
                        sharedData.setCurrentThread(SharedData.THREAD_3);
                    }
                    sharedData.notifyAll();
                    sharedData.wait();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // kết thúc luuongf
        synchronized (sharedData){
            sharedData.notifyAll();
        }
    }
}
