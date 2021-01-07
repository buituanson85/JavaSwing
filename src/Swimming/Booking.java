/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swimming;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Booking {
    String ticketCode, durationCode;
    Date checkIntime;

    public Booking() {
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public String getDurationCode() {
        return durationCode;
    }

    public void setDurationCode(String durationCode) {
        this.durationCode = durationCode;
    }

    public Date getCheckIntime() {
        return checkIntime;
    }

    public void setCheckIntime(Date checkIntime) {
        this.checkIntime = checkIntime;
    }
    public void input(){
         Scanner sc = new Scanner(System.in);
         
         System.out.println("Bạn dùng vé tháng hay ngày");
         System.out.println("1.Tháng");
         System.out.println("2.ngày");
         System.out.println("Chọn: ");
         int choice = Integer.parseInt(sc.nextLine());
         switch(choice){
             case 1:
                 System.out.println("Nhập mã ticker code: ");
                 ticketCode = sc.nextLine();
                 break;
            default:
                DallyTicket daylTicket = new DallyTicket();
                daylTicket.input();
                //nhập song lưu vào dataMrg
                
                //get ticketcode
                ticketCode = daylTicket.getCode();
         }
         System.out.println("Nhập khung giờ vào: ");
         durationCode = sc.nextLine();
         
         checkIntime = new Date();
    }
}
