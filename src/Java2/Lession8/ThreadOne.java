package Java2.Lession8;

public class ThreadOne extends Thread{
    SharedData sharedData;

    public ThreadOne(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        for (int i = 0; i < sharedData.userList.length; i++){
            synchronized (sharedData){
                System.out.println("UserName : " + sharedData.userList[i]);

                sharedData.notifyAll();
                //cách 2
                if (i < sharedData.userList.length - 1) {
                    try {
                        sharedData.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    ThreadOne.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Stop 1");
        //cách 1:
//        synchronized (sharedData){
//            sharedData.notifyAll();
//        }
    }
}
