package JavaII.Lab3;

import java.util.Random;

public class MultipleThreads extends Thread {
    String name;

    public MultipleThreads() {
    }

    public MultipleThreads(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        while (true){
            Random random = new Random(1000);
            name = Thread.currentThread().getName();
            System.out.println(name);
            try {
                int a = (int) (Math.random()*1000);
                Thread.sleep(a);
//                Thread.sleep(random.nextInt(1000));
//
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
