package JavaII.Java2.Theath;

public class TheathOne extends Thread {
    @Override
    public void run() {
        System.out.println("t1 is running");
        for (int i = 0; i < 10; i++){
            System.out.println("Theath One --> " + i);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
