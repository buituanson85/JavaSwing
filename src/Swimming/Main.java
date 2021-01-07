/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swimming;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++){
            Ticket.autoGenerateCode();
            System.out.printf(Ticket.code);
            System.out.println("");
        }
                
    }
}
