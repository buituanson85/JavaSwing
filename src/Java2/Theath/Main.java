package Java2.Theath;

public class Main {
    public static void main(String[] args) {
        //theath main -->luồng chính
        System.out.println("Start");
        //cách 1
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++){
                    System.out.println("Theath --> " + i);
                }
            }
        });
        thread.start();

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++){
                System.out.println("Theath2 --> " + i);
            }
        });
        thread2.start();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        System.out.println("End");
    }
}
