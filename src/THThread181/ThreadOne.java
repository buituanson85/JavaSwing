/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package THThread181;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ThreadOne extends Thread{
    ShareData shareData;
    
    public ThreadOne(ShareData shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        int min = (int) 'a';
        int max = (int) 'z';
        Random random = new Random();
        int delta = max - min; // chạy từ a đến z
        
        while (true) {            
           synchronized(shareData){
                int rad = random.nextInt(delta) + min;
                shareData.setC((char) rad);
                System.out.println((char) rad);
                shareData.notifyAll();
               try {
                   shareData.wait();
               } catch (InterruptedException ex) {
                   Logger.getLogger(ThreadOne.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
            
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadOne.class.getName()).log(Level.SEVERE, null, ex);
            }
            shareData.addCountDown(2);
        }
    }
    
}
