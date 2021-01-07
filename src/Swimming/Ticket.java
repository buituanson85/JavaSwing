/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swimming;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Ticket {
    public static String durationCode;
    public static String code;
    static List<Character> cList = new ArrayList<>();
    static List<Integer> indexList = new ArrayList<>();
     Date registeredDate;

    public Ticket() {
    }

    public Ticket(String code, Date registeredDate) {
        this.code = code;
        this.registeredDate = registeredDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }
    public static void autoGenerateCode(){
        //thực hiện add tất cả tất cả các ký tự từ a-->z A-->Z 0-->9
       autoGenerateChar();
       //code có trức năng sinh tự động 
       //code có độ dài bằng  6 ký tự >> aaaaaa
       code = "";
        for (int i = 0; i < indexList.size(); i++) {
            int currenIdenx = indexList.get(i);
            code += String.valueOf(cList.get(currenIdenx));
        }
        int lastIndex = indexList.size() - 1;
        indexList.set(lastIndex, indexList.get(lastIndex) + 1);
        for (int i = indexList.size() - 1; i > 0; i--) {
            if (indexList.get(i) < cList.size()) {
                break;
            }
            indexList.set(i, 0);
            indexList.set(i - 1, indexList.get(i - 1) + 1);
        }
    }
    
    private static void autoGenerateChar(){ 
        if (cList.size() > 0) return;
         //sinh tự động mã code
        // code có 6 ký tự 
        for (int i = (int)'a' ; i < (int)'z'; i++) {
            cList.add((char) i);
        }
        for (int i = (int)'A' ; i < (int)'Z'; i++) {
            cList.add((char) i);
        }
        for (int i = (int)'0' ; i < (int)'9'; i++) {
            cList.add((char) i);
        }
        
        //lưu index tại thời điểm hiện tại
        for (int i = 0; i < 6; i++) {
            indexList.add(0);
        }
    }
    
    public Date covertStringDate(String str){
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return dateFormat.parse(str);
        } catch (ParseException ex) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Date();
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        autoGenerateCode();
        
        System.out.println("Nhập registeredDate (dd/MM/YYYY)");
        String registeredDateStr = sc.nextLine();
        //convert từ String sang date
        registeredDate = covertStringDate(registeredDateStr);
        
    }
}
