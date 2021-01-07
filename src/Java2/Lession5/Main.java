package Java2.Lession5;

public class Main {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();
//        CustomThread customThread = new CustomThread(sharedData);
        CustomThread t1 = new CustomThread(sharedData);
        CustomThread t2 = new CustomThread(sharedData);
        CustomThread t3 = new CustomThread(sharedData);
        CustomThread t4 = new CustomThread(sharedData);
        CustomThread t5 = new CustomThread(sharedData);
//        customThread.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
