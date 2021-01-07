/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai7.Model;

import Bai7.DAO.SubjectDAO;

/**
 *
 * @author Admin
 */
public class Subject extends School implements ISchool{

    public Subject() {
    }

    public Subject(String id, String name) {
        super(id, name);
    }

    @Override
    public void input() {
        Subject subject = new Subject();
        super.input();
        SubjectDAO.inputInto(subject);
    }

    @Override
    public void display() {
        super.display();
        System.out.println("");
    }
}
