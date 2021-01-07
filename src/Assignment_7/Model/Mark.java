/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_7.Model;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Mark {
    private String idStudent;
    private String idSub;
    private String idSem;
    private float pga;
    private String nameStudent;
    private String nameClass;
    private String nameSub;
    private String nameSem;
    private String daleSem;

    public Mark() {
    }

    public Mark(String idStudent, String idSub, String idSem, float pga, String nameStudent, String nameClass, String nameSub, String nameSem, String daleSem) {
        this.idStudent = idStudent;
        this.idSub = idSub;
        this.idSem = idSem;
        this.pga = pga;
        this.nameStudent = nameStudent;
        this.nameClass = nameClass;
        this.nameSub = nameSub;
        this.nameSem = nameSem;
        this.daleSem = daleSem;
    }

    public Mark(String idStudent, String nameClass, String nameStudent, float pga, String nameSub, String nameSem, String daleSem) {
        this.idStudent = idStudent;
        this.pga = pga;
        this.nameStudent = nameStudent;
        this.nameClass = nameClass;
        this.nameSub = nameSub;
        this.nameSem = nameSem;
        this.daleSem = daleSem;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getIdSub() {
        return idSub;
    }

    public void setIdSub(String idSub) {
        this.idSub = idSub;
    }

    public String getIdSem() {
        return idSem;
    }

    public void setIdSem(String idSem) {
        this.idSem = idSem;
    }

    public float getPga() {
        return pga;
    }

    public void setPga(float pga) {
        this.pga = pga;
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

    public String getNameSub() {
        return nameSub;
    }

    public void setNameSub(String nameSub) {
        this.nameSub = nameSub;
    }

    public String getNameSem() {
        return nameSem;
    }

    public void setNameSem(String nameSem) {
        this.nameSem = nameSem;
    }

    public String getDaleSem() {
        return daleSem;
    }

    public void setDaleSem(String daleSem) {
        this.daleSem = daleSem;
    }
    

    public void insert(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id sinh viên: ");
        idStudent = sc.nextLine();
        System.out.println("Nhập id môn học: ");
        idSub = sc.nextLine();
        System.out.println("Nhập id học kỳ: ");
        idSem = sc.nextLine();
        System.out.println("NHập điểm: ");
        pga = Float.parseFloat(sc.nextLine());
    }
    public void display(){
        System.out.println("id: " + idStudent + ",Tên Sv : " + nameStudent + ",Tên Lớp: " 
                + nameClass + ",Điểm: " + pga + ",Tên MH: " + nameSub + ",Tên HK: " + nameSem + ",Năm học: " + daleSem);
    }
}
