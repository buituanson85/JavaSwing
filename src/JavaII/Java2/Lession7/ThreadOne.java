package JavaII.Java2.Lession7;

import java.util.Random;

public class ThreadOne extends Thread {
    SharedData sharedData;

    public ThreadOne(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Random random = new Random();

        while (sharedData.checkAvaiable()){
           synchronized (sharedData){
               int rad = random.nextInt(100) + 1;
               sharedData.setRad(rad); //sét biến rad vừa được random ra vào sharedData còn set total
               sharedData.plus(rad); //tính total
               System.out.println("ThreadOne --> " + rad);
               // thiết lập luồng tiếp theo được phép chạy.
               if (rad % 3 == 0){
                   sharedData.setIndex(2);
               }else {
                   sharedData.setIndex(3);
               }

               //sau khi tạo số gẫu nhiên song thì Luông 1 này tự động gọi các luồng còn lại,sau khi gọi các luồng nó sẽ chở về trạng thái wait
               sharedData.notifyAll();
               try {
                   sharedData.wait();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               sharedData.setIndex(1);
           }
        }
        System.out.println("Stop 1");
        synchronized (sharedData){
            sharedData.notifyAll();
        }
    }
}
