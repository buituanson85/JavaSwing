/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaII.Assignment6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class JFrameClassLayout extends JFrame implements ActionListener{
    JFrame jFrame;
    JTextField txt_id_class;
    JTextField txt_name_class;
    JTextField txt_age_class;
    DefaultTableModel tableModel;
    List<Classs> classList = new ArrayList<>();

    public JFrameClassLayout() throws SQLException {
        jFrame = new JFrame("JFrame Class");
        
       
        //id
        JLabel nameJLabel = new JLabel("Name class:");
        nameJLabel.setBounds(20, 10, 120, 30);
        jFrame.add(nameJLabel);
        
        txt_name_class = new JTextField();
        txt_name_class.setBounds(120, 10, 300, 30);
        jFrame.add(txt_name_class);
        
        //name
        
        JLabel ageJLabel = new JLabel("Age class:");
        ageJLabel.setBounds(20, 60, 120, 30);
        jFrame.add(ageJLabel);
        
        txt_age_class = new JTextField();
        txt_age_class.setBounds(120, 60, 300, 30);
        jFrame.add(txt_age_class);
        
        //button
        
        JButton saveButton = new JButton("Save");
        saveButton.setBounds(30, 120, 80, 30);
        jFrame.add(saveButton);
        saveButton.addActionListener(this);
        
//        Table model
        
//        ListClassModel classModel = new ListClassModel();
//        JTable table = new JTable(classModel);
//        table.setBounds(130, 140,200,300);
//        JScrollPane sp = new JScrollPane(table);
//        jFrame.add(sp);
         //layour
        jFrame.setSize(500, 500);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    public static void main(String[] args) throws SQLException {
        new JFrameClassLayout();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         String nameClass = txt_name_class.getText();
         String ageClass = txt_age_class.getText();
         
         ClassModify classModify = new ClassModify();
         classModify.insert(nameClass, ageClass);
//         Classs classs = new Classs(nameClass, ageClass);
      
//         ClassModify.insert(classs);
         JOptionPane.showMessageDialog(jFrame, "Successfully added");
         txt_name_class.setText("");
         txt_age_class.setText("");
    }
}
