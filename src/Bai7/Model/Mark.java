/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai7.Model;

import Bai7.DAO.MarkDAO;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Mark implements ISchool{
    List<ISchool> isList;
    private String idStudent;
    private String idSub;
    private String idSem;
    private float pga;
    private String nameStudent;
    private String nameClass;
    private String nameSem;
    private String nameSub;
    private String dateSem;

    public Mark( String nameClass, String idStudent, String nameStudent, float pga, String nameSub, String nameSem, String dateSem) {
        this.idStudent = idStudent;
        this.pga = pga;
        this.nameStudent = nameStudent;
        this.nameClass = nameClass;
        this.nameSem = nameSem;
        this.nameSub = nameSub;
        this.dateSem = dateSem;
    }
    
    public Mark() {
    }

    public Mark(String idStudent, String idSub, String idSem, float pga) {
        this.idStudent = idStudent;
        this.idSub = idSub;
        this.idSem = idSem;
        this.pga = pga;
    }

    public Mark(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getIdStudent() {
        return idStudent;
    }

    public boolean setIdStudent(String idStudent) {
        if (idStudent!= null && !idStudent.contains(" ") && !idStudent.isEmpty()){
           this.idStudent = idStudent;
            return true;
        }else {
            System.err.println("You have not entered a customer idSub");
            return false;
        }
    }

 

    public String getIdSub() {
        return idSub;
    }

    public boolean setIdSub(String idSub) {
        if (idSub!= null && !idSub.contains(" ") && !idSub.isEmpty()){
           this.idSub = idSub;
            return true;
        }else {
            System.err.println("You have not entered a customer idSub");
            return false;
        }
    }

    public String getIdSem() {
        return idSem;
    }

    public boolean setIdSem(String idSem) {
        
        if (idSem!= null && !idSem.contains(" ") && !idSem.isEmpty()){
           this.idSem = idSem;
            return true;
        }else {
            System.err.println("You have not entered a customer idSem");
            return false;
        }
    }

    public float getPga() {
        return pga;
    }

    public boolean setPga(float pga) {
        if (pga >= 0 && pga <= 10){
            this.pga = pga;
            return true;
        }else {
            System.err.println("pga => 0 or pga <= 10");
            return false;
        }
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
        
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public String getNameSem() {
        return nameSem;
    }

    public void setNameSem(String nameSem) {
        this.nameSem = nameSem;
    }

    public String getNameSub() {
        return nameSub;
    }

    public void setNameSub(String nameSub) {
        this.nameSub = nameSub;
    }

    public String getDateSem() {
        return dateSem;
    }

    public void setDateSem(String dateSem) {
        this.dateSem = dateSem;
    }


    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id sinh viên: "); 
        idStudent = sc.nextLine();
        
        System.out.println("Nhập id môn học: ");
        idSub = sc.nextLine();
        System.out.println("Nhập id học kỳ: ");
        idSem = sc.nextLine();
        System.out.println("Nhập điểm: ");
        pga = Float.parseFloat(sc.nextLine());
        MarkDAO.inputInto(idStudent, idSub, idSem, pga);
    }

    @Override
    public void display() {
        System.out.printf("%-20s %-20s %-20s %-20f %-20s %-20s %-20s", nameClass, idStudent, nameStudent, pga, nameSub, nameSem, dateSem);
        System.out.println("");
    }
}
