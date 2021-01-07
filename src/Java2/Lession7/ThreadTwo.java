package Java2.Lession7;

public class ThreadTwo extends Thread {
    SharedData sharedData;

    public ThreadTwo(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
       while (sharedData.checkAvaiable()){
           synchronized (sharedData){
               sharedData.notifyAll();
               try {
                   while (sharedData.getIndex() != 2 && sharedData.checkAvaiable()){
                       sharedData.wait();
                   }
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }

               int rad = sharedData.getRad();
               if (rad % 3 == 0){
                   rad *= rad;
                   System.out.println("ThreadTwo --> " + rad);
               }
               sharedData.setIndex(1);
           }
       }
        System.out.println("Stop 2");
        synchronized (sharedData){
            sharedData.notifyAll();
        }
    }
}
