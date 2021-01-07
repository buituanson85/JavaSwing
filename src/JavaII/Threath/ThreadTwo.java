package JavaII.Threath;

public class ThreadTwo extends Thread {
    String name;

    public ThreadTwo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Luồng T2 ==> " + i + " ==> " + isAlive());
        }
    }
}
