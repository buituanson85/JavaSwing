/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swimming;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class DallyTicket extends Ticket{
    String durationCode;
    Scanner sc = new Scanner(System.in);
    
    public DallyTicket() {
    }

    public String getDurationCode() {
        return durationCode;
    }

    public void setDurationCode(String durationCode) {
        this.durationCode = durationCode;
    }

    @Override
    public void input() {
        super.input(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Mã khung giờ: ");
        durationCode = sc.nextLine();
    }
    
}
