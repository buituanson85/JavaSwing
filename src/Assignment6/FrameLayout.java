/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class FrameLayout extends JFrame implements ActionListener{

    private JButton btnClass;
    private JButton btnStudent;
    private JButton btnAdd;
    private DefaultTableModel tableModel;
    private JTable listTable;
    private List<Classs> classsList;
    
    
    public FrameLayout(String title) throws HeadlessException {
        super(title);
        initUI();
//        classInitUI();
        addAction();
    }
    
     private void addAction() {
        btnClass.addActionListener(this);
        btnStudent.addActionListener(this);
    }

    private void initUI() {
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        JPanel jpBorder = new JPanel(new BorderLayout());
        
        //bắt đầu north
        JPanel jpNorth = new JPanel();
        
        Font fTittle = new Font("Tahoma", Font.BOLD, 20);
        JLabel jlTittle = new JLabel("Thông Tin Sinh Viên");
        jlTittle.setFont(fTittle);
        jlTittle.setForeground(Color.red);
        jpNorth.add(jlTittle);
        jpBorder.add(jpNorth, BorderLayout.NORTH);
        
         //kết thúc north
        JPanel jpCenter = new JPanel();
        btnClass = new JButton("Class");
        jpCenter.add(btnClass);
        btnStudent = new JButton("Student");
        jpCenter.add(btnStudent);
        
        jpBorder.add(jpCenter, BorderLayout.CENTER);
       
        
        //add cả boder vào JFrame
        this.add(jpBorder);
    }
    
    public static void main(String[] args) {
        new FrameLayout("Quan ly sinh vien").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Class")) {
             System.out.println("chạy vào nút Class");
            new ClassListLayout("Danh sách lớp").setVisible(true);
             
        }else if (e.getActionCommand().equals("Student")) {
                System.out.println("chạy vào nút Student");
            try {
                new StudentListLayout("Danh sách sinh viên").setVisible(true);
            } catch (HeadlessException ex) {
                Logger.getLogger(FrameLayout.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(FrameLayout.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
