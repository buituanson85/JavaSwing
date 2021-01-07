/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5;

import java.awt.Frame;
import javax.swing.JButton;

/**
 *
 * @author Admin
 */
public class TestFram {
    public static void main(String[] args) {
        Frame j = new Frame("Swing demo");
        
        JButton click = new JButton("submit");
        click.setBounds(100, 100, 100, 30);
        j.add(click);
        
       JButton close = new JButton("Close");
       click.setBounds(220, 100, 100, 30);
        j.add(close);
       
        j.setSize(400, 500);
        j.setLayout(null);
        j.setVisible(true);
        
    }
}
