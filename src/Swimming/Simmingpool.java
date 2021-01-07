/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swimming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Simmingpool {
    List<MothTichket> monthTickets = new ArrayList<>();
    List<DallyTicket> dallyTickets = new ArrayList<>();
    List<DurationTime> durationTimes = new ArrayList<>();
    List<Booking> bookings = new ArrayList<>();
    
    String code;
    String address;

    public Simmingpool() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<MothTichket> getMonthTickets() {
        return monthTickets;
    }

    public void setMonthTickets(List<MothTichket> monthTickets) {
        this.monthTickets = monthTickets;
    }

    public List<DallyTicket> getDallyTickets() {
        return dallyTickets;
    }

    public void setDallyTickets(List<DallyTicket> dallyTickets) {
        this.dallyTickets = dallyTickets;
    }

    public List<DurationTime> getDurationTimes() {
        return durationTimes;
    }

    public void setDurationTimes(List<DurationTime> durationTimes) {
        this.durationTimes = durationTimes;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
    
    public void input(){
         Scanner sc = new Scanner(System.in);
         
         System.out.println("Nhập mã code: ");
         code = sc.nextLine();
         
         System.out.println("Nhập địa chỉ: ");
         address = sc.nextLine();
         
    }
}
