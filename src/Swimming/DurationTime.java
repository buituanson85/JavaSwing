/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swimming;

import static Swimming.Ticket.indexList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class DurationTime {
    static List<Character> cList = new ArrayList<>();
    static List<Integer> indexList = new ArrayList<>();
    
    static String durationCode;
    int fromTime, toTime;
    int price;

    public DurationTime() {
    }

    public static List<Character> getcList() {
        return cList;
    }

    public static void setcList(List<Character> cList) {
        DurationTime.cList = cList;
    }

    public static List<Integer> getIndexList() {
        return indexList;
    }

    public static void setIndexList(List<Integer> indexList) {
        DurationTime.indexList = indexList;
    }

    public String getDurationCode() {
        return durationCode;
    }

    public void setDurationCode(String durationCode) {
        this.durationCode = durationCode;
    }

    public int getFromTime() {
        return fromTime;
    }

    public void setFromTime(int fromTime) {
        this.fromTime = fromTime;
    }

    public int getToTime() {
        return toTime;
    }

    public void setToTime(int toTime) {
        this.toTime = toTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
    public static void autoGenerateCode(){
        
       autoGenerateChar();
       
       durationCode = "";
        for (int i = 0; i < indexList.size(); i++) {
            int currenIdenx = indexList.get(i);
            durationCode += String.valueOf(cList.get(currenIdenx));
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
    
    public static void autoGenerateChar(){
        if (cList.size() > 0) return;
         //chỉ lưu ký tự từ 0 - 9 2 mã
        for (int i = (int)'0' ; i < (int)'9'; i++) {
            cList.add((char) i);
        }
        
        //lưu index tại thời điểm hiện tại
        for (int i = 0; i < 2; i++) {
            indexList.add(0);
        }
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        autoGenerateCode();
        
        System.out.println("Thời gian bắt đầu: ");
        fromTime = Integer.parseInt(sc.nextLine());
        System.out.println("thời gian kết thúc: ");
        toTime = Integer.parseInt(sc.nextLine());
        System.out.println("Giá khung giờ: ");
        price = Integer.parseInt(sc.nextLine());
        
    }
}
