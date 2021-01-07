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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class StudentListLayout extends JFrame implements ActionListener{

    private JButton btnAdd;
    private DefaultTableModel tableModel;
    private JTable listTable;
    private List<Students> studentsList;
    
    public StudentListLayout(String title) throws HeadlessException, SQLException {
        super(title);
        studentInitUI();
        addAction();
    }
    
    private void addAction() {
        btnAdd.addActionListener(this);
    }
    
    private void studentInitUI() throws SQLException {
        this.setSize(400, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        JPanel jpBorder = new JPanel(new BorderLayout());
        
        JPanel jpNorth = new JPanel();
        //tiêu đề
        JPanel jpNorthTop = new JPanel();
        Font fTittle = new Font("Tahoma", Font.BOLD, 20);
        JLabel jlTittle = new JLabel("Danh sách sinh viên");
        jlTittle.setFont(fTittle);
        jlTittle.setForeground(Color.red);
        jpNorthTop.add(jlTittle);
        jpNorth.add(jpNorthTop);
        
        JPanel jpCenter = new JPanel();
        Border borderWest = BorderFactory.createLineBorder(Color.BLACK);
        TitledBorder titledBorder = new TitledBorder(borderWest, "Danh sách sinh viên:");
        jpCenter.setBorder(titledBorder);
        tableModel = new DefaultTableModel();
        studentsList = StudentDAO.findAll();
        Object[] columnTittle = {"id", "name", "age", "name_class"};
        tableModel.setColumnIdentifiers(columnTittle);
        Object[] rowData = null;
        for (Students students : studentsList) {
            rowData = new Object[] { students.getId_student(), students.getName_student(), students.getAge_student(), students.getName_class()};
            tableModel.addRow(rowData);
        }
        
        listTable = new JTable();
        
        listTable.setModel(tableModel);
        listTable.setPreferredSize(new Dimension(370, 485));
        jpCenter.add(listTable);
        jpBorder.add(jpCenter, BorderLayout.CENTER);
       
        //bắt đầu sout
        JPanel jpSouth = new JPanel();
        btnAdd  = new JButton("Add");
        jpSouth.add(btnAdd);
        jpBorder.add(jpSouth, BorderLayout.SOUTH);
        
        this.add(jpBorder);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new MenuStudentLayout("Thêm mới sinh viên").setVisible(true);
    }
}
