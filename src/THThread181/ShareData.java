/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package THThread181;

/**
 *
 * @author Admin
 */
public class ShareData {
    char c;
    int countDown = 0;
    
    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public int getCountDown() {
        return countDown;
    }

    public void setCountDown(int countDown) {
        this.countDown = countDown;
    }
    
    public synchronized void addCountDown(int add){
         countDown += add;
    }
}
