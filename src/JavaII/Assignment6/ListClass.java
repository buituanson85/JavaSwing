/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaII.Assignment6;

import javax.swing.*;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class ListClass extends JFrame{
    JFrame jFrame;

    public ListClass() throws SQLException{
        jFrame = new JFrame();
        
        ListClassModel classModel = new ListClassModel();
        JTable table = new JTable(classModel);
        table.setBounds(30, 40,200,300);
        JScrollPane sp = new JScrollPane(table);
        jFrame.add(sp);

        jFrame.setSize(500, 500);
//        j.setLayout(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) throws SQLException {
        new ListClass();
    }
}
