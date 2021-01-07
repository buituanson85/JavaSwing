package Java2.Theath;

public class TheathTwo implements Runnable {
    //cách join t1 và t2
    TheathOne t1;

    public TheathTwo() {
    }

    public TheathTwo(TheathOne t1) {
        this.t1 = t1;
    }

    @Override
    public void run() {
        System.out.println("t2 is running");
        try {
            System.out.println("join t1 into t2");
            t1.join();
            System.out.println("t1 is finish");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++){
            System.out.println("Theath Two --> " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
