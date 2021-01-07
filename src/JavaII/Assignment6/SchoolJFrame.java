/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaII.Assignment6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class SchoolJFrame extends JFrame implements ActionListener{
    JFrame jFrame;

    public SchoolJFrame() {
        jFrame = new JFrame("SchoolJFrame Class");
        
        JButton classButton = new JButton("Class");
        classButton.setBounds(30, 120, 80, 30);
        jFrame.add(classButton);
        classButton.addActionListener(this);
        
        JButton studentButton = new JButton("Student");
        studentButton.setBounds(230, 120, 80, 30);
        jFrame.add(studentButton);
        studentButton.addActionListener(this);
        
        jFrame.setSize(500, 500);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
//        JFrameClassLayout();
    }
    public static void main(String[] args) {
        new SchoolJFrame();
    }
}
