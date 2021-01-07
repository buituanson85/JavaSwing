package Java2.Theath;

public class Test1 {
    public static void main(String[] args) {
        System.out.println("Thread main start");
        TheathOne t1 = new TheathOne();
        Thread t2 = new Thread(new TheathTwo(t1));

        t1.start();
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread main stop");
    }
}
