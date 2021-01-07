/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package THThread181;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ThreadTwo extends Thread{
    ShareData shareData;

    public ThreadTwo(ShareData shareData) {
        this.shareData = shareData;
    }

    public ThreadTwo() {
    }

    public ShareData getShareData() {
        return shareData;
    }

    public void setShareData(ShareData shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        while (true) {            
            synchronized(shareData){
                shareData.notifyAll();
                try {
                    shareData.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadTwo.class.getName()).log(Level.SEVERE, null, ex);
                }
                char c = shareData.getC();
                char C = (char) ((int) c - 32);
                System.out.println(C);
            }
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadTwo.class.getName()).log(Level.SEVERE, null, ex);
            }
            shareData.addCountDown(1);
        }
    }
    
}
