package Java2.Lession6;

import java.io.*;

public class ThreadTwo extends Thread {
    SharedData sharedData;

    public ThreadTwo(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        // kiểm tra các luồng còn tiếp tục chạy hay ko
        while (sharedData.isAlive()){
            synchronized (sharedData){
                sharedData.notifyAll();
                try {
                    while (sharedData.getCurrentThread() != SharedData.THREAD_2 && sharedData.isAlive()){
                        sharedData.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                int length = sharedData.getValidRollNumber().size();
                if (length > 0){
                    Student student = sharedData.getValidRollNumber().get(length - 1);
                    System.out.println("Welcome student has roll number is : " + student.getRollNo());
                    System.out.println("Valid collection has length : " + length);

                    //ghi vào file.dat
                    FileOutputStream fos = null;
                    ObjectOutputStream oos = null;
                    try {
                         fos = new FileOutputStream(student.getRollNo() + ".dat");
                         oos = new ObjectOutputStream(fos);

                         oos.writeObject(student);
                    } catch (FileNotFoundException e) {
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
                        if (oos != null){
                            try {
                                oos.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }else {
                    System.out.println("err");
                }

                sharedData.setCurrentThread(SharedData.THREAD_1);
            }
        }
        // kết thúc luuongf
        synchronized (sharedData){
            sharedData.notifyAll();
        }
    }
}
