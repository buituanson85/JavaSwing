/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_7.Model;

import java.util.Scanner;
import java.text.SimpleDateFormat;
/**
 *
 * @author Admin
 */
public class Semester extends Programa{
    private String dateSem;
    Scanner sc = new Scanner(System.in);
    
    public Semester(String dateSem, String id, String name) {
        super(id, name);
        this.dateSem = dateSem;
    }

    public Semester(String dateSem) {
        this.dateSem = dateSem;
    }

    public Semester() {
    }

    public String getDateSem() {
        return dateSem;
    }

    public void setDateSem(String dateSem) {
        this.dateSem = dateSem;
    }
    
    @Override
    public void display(){
        super.display();
        System.out.println(" ,Date: " + dateSem);
    }
}
