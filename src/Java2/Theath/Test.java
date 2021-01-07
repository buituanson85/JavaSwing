package Java2.Theath;

public class Test {
    public static void main(String[] args) {
        //cách 2
        System.out.println("Theath main start");
        TheathOne theathOne = new TheathOne();
        theathOne.start();

        TheathTwo theathTwo = new TheathTwo();
        Thread t = new Thread(theathTwo);
        t.start();
        try {
            System.out.println("thực hiện join luồng một vào main");
            theathOne.join();
            System.out.println("thực hiện join luồng hai vào main");
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Theath main stop");
//        try {
//            Thread.sleep(5000);
//            theathOne.stop();
//            t.stop();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
