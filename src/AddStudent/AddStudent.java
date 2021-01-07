/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddStudent;

import Lab4.dao.SinhVienDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class AddStudent extends JFrame implements ActionListener{
    JFrame jFrame;
    JTextField txt_name;
    JTextField txt_address;
    JTextField txt_tel;
    
    public AddStudent(){
        jFrame = new JFrame("Thêm mới sinh viên");
        
        JLabel nJLabel = new JLabel("Tên");
        nJLabel.setBounds(10, 10, 100, 30);
        jFrame.add(nJLabel);
        
        txt_name = new JTextField();
        txt_name.setBounds(120, 10, 260, 30);
        jFrame.add(txt_name);
        
        JLabel aJLabel = new JLabel("Địa chỉ");
        aJLabel.setBounds(10, 50, 100, 30);
        jFrame.add(aJLabel);
        
        txt_address = new JTextField();
        txt_address.setBounds(120, 50, 260, 30);
        jFrame.add(txt_address);
        
        JLabel tJLabel = new JLabel("Điện thoại");
        tJLabel.setBounds(10, 90, 100, 30);
        jFrame.add(tJLabel);
        
        txt_tel = new JTextField();
        txt_tel.setBounds(120, 90, 260, 30);
        jFrame.add(txt_tel);
        
        JButton addButton = new JButton("Save");
        addButton.setBounds(140, 160, 80, 30);
        jFrame.add(addButton);
        addButton.addActionListener(this);
        
        jFrame.setSize(400, 500);
        jFrame.setLayout(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SinhVienDAO sinhVienDAO = new SinhVienDAO();
        
        sinhVienDAO.create(txt_name.getText(),
                txt_address.getText(),
                txt_tel.getText());
        JOptionPane.showMessageDialog(this, "OK");
        txt_name.setText("");
        txt_address.setText("");
        txt_tel.setText("");
    }
    
    public static void main(String[] args) {
        new AddStudent();
    }
}
