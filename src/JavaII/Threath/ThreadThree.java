package JavaII.Threath;

public class ThreadThree implements Runnable {
    String name;
    Thread t3;

    public ThreadThree(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "Luồng t3 ==> " + i );
        }
    }
}
