package Java2.Lession7;

public class ThreadThree extends Thread {
    SharedData sharedData;

    public ThreadThree(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        while (sharedData.checkAvaiable()){
            synchronized (sharedData){
                sharedData.notifyAll();
                try {
                    while (sharedData.getIndex() != 3 && sharedData.checkAvaiable()){
                        sharedData.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int rad = sharedData.getRad();
                if (rad % 2 == 0){
                    if (rad % 4 == 0){
                        System.out.println("ThreadThree --> số rad chia hết cho 4: " + rad);
                    }else {
                        System.out.println("ThreadThree --> số rad không chia hết cho 4: " + rad);
                    }
                }else {
                    System.out.println("ThreadThree --> Số lẻ: " + rad);
                }
            }
        }
        System.out.println("Stop 3");
        synchronized (sharedData){
            sharedData.notifyAll();
        }
    }
}
