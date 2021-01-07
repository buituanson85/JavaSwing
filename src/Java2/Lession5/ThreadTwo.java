package Java2.Lession5;

import java.util.Random;

public class ThreadTwo extends Thread {
    SharedData sharedData;

    public ThreadTwo(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            synchronized (sharedData){
                if (i == 9){
                }
                System.out.println("T2 >> i >> " + i);
                sharedData.notifyAll();
                try {
                    sharedData.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int result = sharedData.rad * sharedData.rad;
                System.out.println("T2 >> " + result);

//                sharedData.notifyAll(); ko để ở đây tránh bị deslock
            }
        }
    }
}
