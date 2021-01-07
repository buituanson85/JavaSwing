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
public class Main {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        
        ThreadOne threadOne = new ThreadOne(shareData);
        ThreadTwo threadTwo = new ThreadTwo(shareData);
        threadOne.start();
        threadTwo.start();
        
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {                    
                    try {
                    Thread.sleep(10000);
                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(shareData.getCountDown() >= 10){
                    threadOne.stop();
                    threadTwo.stop();
                    break;
                } 
                }
            }
        });
        t.start();
        
    }
}
