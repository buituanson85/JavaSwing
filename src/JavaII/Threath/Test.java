package JavaII.Threath;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        MyBanks myBanks = new MyBanks(1000);
//        myBanks.withDraw(800, "T0");
//        myBanks.withDraw(800, "T1");
//        myBanks.withDraw(800, "T2");

        List<WithDrawThread> threadList = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            WithDrawThread drawThread = new WithDrawThread(myBanks,"T" + i);
            threadList.add(drawThread);
        }

        for (WithDrawThread withDrawThread : threadList){
            withDrawThread.start();
        }
    }
}
