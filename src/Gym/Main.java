/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gym;

import Bai7.DAO.ClassDAO;
import Bai7.Model.ISchool;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int rad = random.nextInt(3);
            
            IInputOutPut io;
            switch(rad){
                case 0:
                    io = new Instruction();
                    break;
                case 1:
                    io = new Drings();
                    break;
                default:
                    io = new Ticket();
                    break;
            }
            io.input();
            DataMrg.getInstance().getIiopList().add(io);
        }
        
        for (IInputOutPut io : DataMrg.getInstance().getIiopList()) {
            io.display();
        }
    }
}
