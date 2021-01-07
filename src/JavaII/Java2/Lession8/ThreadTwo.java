package JavaII.Java2.Lession8;

public class ThreadTwo extends Thread{
    SharedData sharedData;

    public ThreadTwo(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        for (int i = 0; i < sharedData.addressList.length; i++){
            synchronized (sharedData){
                sharedData.notifyAll();
                try {
                    sharedData.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Address : " + sharedData.addressList[i]);
            }
        }
        System.out.println("Stop 2");
        //cách 1:
//        synchronized (sharedData){
//            sharedData.notifyAll();
//        }
    }
}
