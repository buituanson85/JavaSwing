/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai7.Model;

import Bai7.DAO.ClassDAO;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Classs extends School implements ISchool{
    
    public Classs() {
    }

    public Classs(String id, String name) {
        super(id, name);
    }

    @Override
    public void input() {
        Classs classs = new Classs();
        super.input();
        ClassDAO.inputInto(classs);
    }

    @Override
    public void display() {
        super.display();
        System.out.println("");
    }
    
}
