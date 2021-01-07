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
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class MenuClassLayout extends JFrame implements ActionListener{
    private JButton btnSave;
    private JTextField txtName;
    private JTextField txtAge;
    public MenuClassLayout(String title) throws HeadlessException {
        super(title);
        addClassInitUI();
        addAction();
    }
    
    private void addAction() {
        btnSave.addActionListener(this);
    }

    private void addClassInitUI() {
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        JPanel jpBorder = new JPanel(new BorderLayout());
        
        //bawts dau vung north
        JPanel jpNorth = new JPanel();
        Font fTittle = new Font("Tahoma", Font.BOLD, 20);
        JLabel jlTittle = new JLabel("Thêm lớp học");
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
        JLabel jlName = new JLabel("Tên Lớp");
        JLabel jlAge = new JLabel("Khối lớp");
        jpLabel.add(jlName);
        jpLabel.add(Box.createVerticalStrut(25));//tạo khoảng trống
        jpLabel.add(jlAge);
        jpLabel.add(Box.createVerticalStrut(25));
        
        JPanel jpTextField = new JPanel();
        jpTextField.setLayout(new BoxLayout(jpTextField, BoxLayout.Y_AXIS));
        txtName = new JTextField(20);
        txtAge = new JTextField(20);
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
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Save")) {
            String nameClass = txtName.getText();
            int ageClass = Integer.parseInt(txtAge.getText());
            Classs classs = new Classs();
            classs.create( nameClass, ageClass);
            JOptionPane.showMessageDialog(this, "Successfully added");
            System.out.println("chạy vào save");
            txtName.setText("");
            txtAge.setText("");
        }
    }
    
//    public static void main(String[] args) {
//        new AddClassJFrame("Add Class").setVisible(true);
//    }
}
