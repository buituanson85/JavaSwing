package JavaII.Java2.Lession5;

import java.util.Random;

public class ThreadOne extends Thread{
    SharedData sharedData;

    public ThreadOne(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 10; i++){
            synchronized (sharedData){
                System.out.println("T1 >> i >> " + i);
                int rad = random.nextInt(100);
                //xét lại giá trị cho số random
                sharedData.rad = rad;
                System.out.println("T1 >> " + rad);
                sharedData.notifyAll();
                if (i == 9){
                    stop();
                }
                if (i < 9){
                    try {
                        sharedData.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
