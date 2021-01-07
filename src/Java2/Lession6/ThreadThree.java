package Java2.Lession6;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ThreadThree extends Thread {
    SharedData sharedData;

    public ThreadThree(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("D:\\T2004E-JavaII\\src\\Java2\\Lession6\\unvalid.txt");

            while (sharedData.isAlive()){
                synchronized (sharedData){
                    sharedData.notifyAll();
                    while (sharedData.getCurrentThread() != SharedData.THREAD_3 && sharedData.isAlive()){
                        sharedData.wait();
                    }

                    int length = sharedData.getUnvalidRollNumber().size();
                    String rollNo = sharedData.getUnvalidRollNumber().get(length - 1);

                    // hiển thị
                    System.out.println("Unvalid roll number : " + rollNo);

                    //ghi file
                    rollNo += "\n";
                    byte[] b = rollNo.getBytes();
                    fos.write(b);

                    //chuyển luồng
                    sharedData.setCurrentThread(SharedData.THREAD_1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //kết thúc luồng 3
        // kết thúc luuongf
        synchronized (sharedData){
            sharedData.notifyAll();
        }
    }
}
