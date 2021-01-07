package JavaII.Threath;

public class Main {
    public static void main(String[] args) {
        //Thread main ==> luồng chính ==> khởi tạo đầu tiên khi app đc bật lên
        //cách 1
        Thread t1 = new Thread(new Runnable() { //run.. là một lpopws giao diện..
            @Override
            public void run() {
                //gọi code tới xử lý code trong phần này khi t1.start được gọi
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 10; i++){
                    System.out.println("Luồng t1 ==> " + i);
                }
            }
        });
        t1.start();

        //Tại thời điểm này => 2 Thread main và t1

        Thread t2 = new ThreadTwo("T2");
        t2.start();
        //Tại thời điểm này => 2 Thread main và t1 t2

        //cách 3.
        ThreadThree r = new ThreadThree("t3");
        Thread t3 = new Thread(r);
        t3.start();

        //main Thread
        for (int i = 0; i < 100; i++){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T1 >> isAlice >> " + t1.isAlive());
            System.out.println("T2 >> isAlice >> " + t2.isAlive());
            System.out.println("T3 >> isAlice >> " + t3.isAlive());
            System.out.println("Luồng main ==> " + i);

        }
    }
}
