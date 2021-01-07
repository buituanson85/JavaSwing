/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai7.Model;


import Bai7.DAO.SemesterDAO;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Semester implements ISchool{
     private enum NAME{
        SEMI, SEMII, SEMIII, SEMIV
    };
     
    private String id;
    private NAME name;
    private String dateSem;

    public Semester() {
    }

    public Semester(String id, NAME name, String dateSem) {
        this.id = id;
        this.name = name;
        this.dateSem = dateSem;
    }

    public String getId() {
        return id;
    }

    public boolean setId(String id) {
        if (id!= null && !id.contains(" ") && !id.isEmpty()){
            this.id = id;
            return true;
        }else {
            System.err.println("You have not entered a customer id");
            return false;
        }
    }

    public NAME getName() {
        return name;
    }

    public void setName(NAME name) {
        this.name = name;
    }

    public String getDateSem() {
        return dateSem;
    }

    public boolean setDateSem(String dateSem) {
        if (dateSem!= null && !dateSem.contains(" ") && !dateSem.isEmpty()){
            this.dateSem = dateSem;
            return true;
        }else {
            System.err.println("You have not entered a customer date");
            return false;
        }
    }

    public String getSemString(){
        if (name == NAME.SEMI) {
            return "Sem I";
        }else if (name == NAME.SEMII) {
            return "Sem II";
        }else if (name == NAME.SEMIII) {
            return "Sem III";
        }
        return "Sem IV";
    }
    
    @Override
    public String toString() {
        return "id: " + id + ", name: " + getSemString() + ", Date: " + dateSem;
    }
    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id: ");
        while (true) {  
            id = sc.nextLine();
            boolean check = setId(id);
            if (check) {
                break;
            }
        }
        System.out.println("Nhập tên học kỳ");
        System.out.println("1.Sem I");
        System.out.println("2.Sem II");
        System.out.println("3.Sem III");
        System.out.println("4.Sem IV");
        int choice;
        choice = Integer.parseInt(sc.nextLine());
        switch(choice){
            case 1:
                name = NAME.SEMI;
                break;
            case 2:
                name = NAME.SEMII;
                break;
            case 3:
                name = NAME.SEMIII;
                break;
            default:
                name = NAME.SEMIV;
                break;
        }
        System.out.println("Thêm năm học: ");
        while (true) {  
            dateSem = sc.nextLine();
            boolean check = setDateSem(dateSem);
            if (check) {
                break;
            }
        }
        SemesterDAO.inputInto(id, getSemString(), dateSem);
    }
    
    @Override
    public void display() {
        System.out.printf("%-20s %-20s %-20s", id, getSemString(), dateSem);
        System.out.println("");
    }
}
