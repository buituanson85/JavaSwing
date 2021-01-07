/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestA6;

import com.sun.java.accessibility.util.AWTEventMonitor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Admin
 */
public class FrmQLSV extends JFrame implements ActionListener{

    private JButton btnAdd;
    private JButton btnRemove;
    private JButton btnUpdate;
    private JButton btnClear;
    private JTextField txtRollNo;
    private JTextField txtName;
    private JTextField txtAge;
    private DefaultListModel model;
    private JList listStudent;
    private List<Student> studentList;
    public FrmQLSV(String title) throws HeadlessException {
        super(title);
        initUI();
        addAction();
        studentList = Student.getAll();
    }
    
    private void addAction() {
        btnClear.addActionListener(this);
        btnAdd.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnRemove.addActionListener(this);
    }

    private void initUI() {
        this.setSize(600, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        JPanel jpBorder = new JPanel(new BorderLayout());
        //bawts dau vung north
        JPanel jpNorth = new JPanel();
        Font fTittle = new Font("Tahoma", Font.BOLD, 20);
        JLabel jlTittle = new JLabel("Thông Tin Sinh Viên");
        jlTittle.setFont(fTittle);
        jlTittle.setForeground(Color.red);
        jpNorth.add(jlTittle);
        jpBorder.add(jpNorth, BorderLayout.NORTH);
        //ket thuc vung noth
        
        //bawts dau vung south
        JPanel jpSouth = new JPanel();
        btnAdd = new JButton("Add");
        jpSouth.add(btnAdd);
        btnRemove = new JButton("Remove");
        jpSouth.add(btnRemove);
        btnUpdate = new JButton("Update");
        jpSouth.add(btnUpdate);
        btnClear = new JButton("Clear");
        jpSouth.add(btnClear);
        jpBorder.add(jpSouth, BorderLayout.SOUTH);
        
        //ket thuc vung south
        
        //bawts dau vung west
        JPanel jpWest = new JPanel();
        Border borderWest = BorderFactory.createLineBorder(Color.RED);
        TitledBorder titledBorder = new TitledBorder(borderWest, "Danh sách sinh viên");
        jpWest.setBorder(titledBorder);
        model = new DefaultListModel();
        List<Student> studentList =(List<Student>) Student.getAll();
       
        for (Student student : studentList) {
            model.addElement(student.getName());
        }
//        model.addElement("Bùi Tuấn Sơn");
//        model.addElement("Nguyễn Quốc Việt");
        listStudent = new JList();
        listStudent.setModel(model);
        listStudent.setPreferredSize(new Dimension(150, 200));
        
        jpWest.add(listStudent);
        jpBorder.add(jpWest, BorderLayout.WEST);
        //kết thúc vùng west
        
        //Bắt đầu vùng center
        JPanel jpCenter = new JPanel();
        
        JPanel jpLabel = new JPanel();
        jpLabel.setLayout(new BoxLayout(jpLabel, BoxLayout.Y_AXIS)); //căn chỉnh theo trục y
        JLabel jlRollNo = new JLabel("Mã sinh viên");
        JLabel jlName = new JLabel("Họ Tên");
        JLabel jlAge = new JLabel("Tuổi");
        jpLabel.add(jlRollNo);
        jpLabel.add(Box.createVerticalStrut(25));//tạo khoảng trống
        jpLabel.add(jlName);
        jpLabel.add(Box.createVerticalStrut(25));
        jpLabel.add(jlAge);
        jpLabel.add(Box.createVerticalStrut(25));
        
        JPanel jpTextField = new JPanel();
        jpTextField.setLayout(new BoxLayout(jpTextField, BoxLayout.Y_AXIS));
        txtRollNo = new JTextField(20);
        txtName = new JTextField(20);
        txtAge = new JTextField(20);
        jpTextField.add(txtRollNo);
        jpTextField.add(Box.createVerticalStrut(25));
        jpTextField.add(txtName);
        jpTextField.add(Box.createVerticalStrut(25));
        jpTextField.add(txtAge);
        jpCenter.add(jpLabel);
        jpTextField.add(Box.createVerticalStrut(25));
        jpCenter.add(jpTextField);
        
        
        jpBorder.add(jpCenter, BorderLayout.CENTER);
        
        //kết thúc vùng center
        
        this.add(jpBorder);
    }
    public static void main(String[] args) {
        new FrmQLSV("Quan ly sinh vien").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Clear")) {
            System.out.println("chạy vào nút clear");
            txtAge.setText("");
            txtName.setText("");
            txtRollNo.setText("");
        }else if(e.getActionCommand().equals("Add")){
            System.out.println("chạy vào nút Add");
            String _txtRollNo = txtRollNo.getText().trim();
            String _txtName = txtName.getText().trim();
            String _Age = txtAge.getText().trim();
//            model.addElement(_txtRollNo);
            model.addElement(_txtName);
//            model.addElement(_Age);
            JOptionPane.showMessageDialog(rootPane, "Thêm sv thành công");
            txtAge.setText("");
            txtName.setText("");
            txtRollNo.setText("");
        }else if (e.getActionCommand().equals("Remove")) {
            System.out.println("chạy vào nút Remuve");
            int index = listStudent.getSelectedIndex();
            if ( index >= 0) {
                model.remove(index);
                 JOptionPane.showMessageDialog(rootPane, "Bạn xóa thành công " + index);
            }else{
                JOptionPane.showMessageDialog(rootPane, "Bạn phải chọn");
            }
        }else if (e.getActionCommand().equals("Update")) {
            System.out.println("chạy vào nút Update");
            
        }
    }
}
