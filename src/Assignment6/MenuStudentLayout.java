/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class MenuStudentLayout extends JFrame implements ActionListener{
    private List<Classs> classsList;
    private List<Students> studentsList = new ArrayList<>();
    private JButton btnSave;
    private JTextField txtName;
    private JTextField txtAge;
    private JComboBox cbNameClass;
    private DefaultComboBoxModel<Classs> comboBoxModel;
    private JTextField txtIdClass;

    public MenuStudentLayout(String title) throws HeadlessException {
        super(title);
        addStudentInitUI();
        addAction();
    }
    
    private void addStudentInitUI() {
        this.setSize(600, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        JPanel jpBorder = new JPanel(new BorderLayout());
        
        //bawts dau vung north
        JPanel jpNorth = new JPanel();
        Font fTittle = new Font("Tahoma", Font.BOLD, 20);
        JLabel jlTittle = new JLabel("Thêm sinh viên");
        jlTittle.setFont(fTittle);
        jlTittle.setForeground(Color.red);
        jpNorth.add(jlTittle);
        jpBorder.add(jpNorth, BorderLayout.NORTH);
        //ket thuc vung noth
        
        //bawts dau vung south
        JPanel jpSouth = new JPanel();
        btnSave = new JButton("Save");
        jpSouth.add(btnSave);
        jpBorder.add(jpSouth, BorderLayout.SOUTH);
        
        //ket thuc vung south
        
        //Bắt đầu vùng center
        JPanel jpCenter = new JPanel();
        
        JPanel jpLabel = new JPanel();
        jpLabel.setLayout(new BoxLayout(jpLabel, BoxLayout.Y_AXIS)); //căn chỉnh theo trục y
        JLabel jlName = new JLabel("Tên sinh viên");
        JLabel jlAge = new JLabel("tuổi sinh viên");
        JLabel jlIdCbClass = new JLabel("Tên lớp học");
        jpLabel.add(jlName);
        jpLabel.add(Box.createVerticalStrut(25));//tạo khoảng trống
        jpLabel.add(jlAge);
        jpLabel.add(Box.createVerticalStrut(25));
        jpLabel.add(jlIdCbClass);
        jpLabel.add(Box.createVerticalStrut(25));
        
        JPanel jpTextField = new JPanel();
        jpTextField.setLayout(new BoxLayout(jpTextField, BoxLayout.Y_AXIS));
        txtName = new JTextField(20);
        txtAge = new JTextField(20);
        cbNameClass = new JComboBox();
        comboBoxModel = new DefaultComboBoxModel<Classs>();
        classsList = Classs.findALl();
        for (Classs classs : classsList) {
            comboBoxModel.addElement(classs);
        }
        cbNameClass.setModel(comboBoxModel);
        jpTextField.add(txtName);
        jpTextField.add(Box.createVerticalStrut(25));
        jpTextField.add(txtAge);
        jpTextField.add(Box.createVerticalStrut(25));
        jpTextField.add(cbNameClass);
        jpCenter.add(jpLabel);
        jpTextField.add(Box.createVerticalStrut(25));
        jpCenter.add(jpTextField);
        
        jpBorder.add(jpCenter, BorderLayout.CENTER);
        
        //kết thúc vùng center
        
        this.add(jpBorder);
    }
    
    private void addAction() {
        btnSave.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Save")) {
            String nameStudent = txtName.getText();
            int ageStudent = Integer.parseInt(txtAge.getText());
            
            int index = cbNameClass.getSelectedIndex();
            Classs classs = classsList.get(index);
            int idClass = classs.getId_class();
            try {
                //
//            Students students = new Students();
            StudentDAO.insertProduct( nameStudent, ageStudent, idClass);
            } catch (SQLException ex) {
                Logger.getLogger(MenuStudentLayout.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this, "Successfully added");
            System.out.println("chạy vào save");
            txtName.setText("");
            txtAge.setText("");
            txtIdClass.setText("");
        }
    }
//    public static void main(String[] args) {
//        new AddStudentJFrane("Thêm sinh viên").setVisible(true);
//    }
}
