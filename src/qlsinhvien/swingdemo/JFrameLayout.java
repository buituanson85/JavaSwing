package qlsinhvien.swingdemo;

import qlsinhvien.dao.SinhVienDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameLayout extends JFrame implements ActionListener {
    JFrame j;
    JTextField jTextField;
    JTextField jTextField2;
    JTextField jTextField3;

    public JFrameLayout(){
        j = new JFrame();
        JLabel nameLabel = new JLabel("Họ và tên");
        nameLabel.setBounds(20, 10, 100, 30);
        j.add(nameLabel);
        jTextField = new JTextField();
        jTextField.setBounds(140, 10, 300, 30);
        j.add(jTextField);


        JLabel addLabel = new JLabel("Địa chỉ");
        addLabel.setBounds(20, 60, 100, 30);
        j.add(addLabel);
        jTextField2 = new JTextField();
        jTextField2.setBounds(140, 60, 300, 30);
        j.add(jTextField2);




        JLabel telLabel = new JLabel("Số điện thoại");
        telLabel.setBounds(20, 110, 100, 30);
        j.add(telLabel);
        jTextField3 = new JTextField();
        jTextField3.setBounds(140, 110, 300, 30);
        j.add(jTextField3);

        JButton addBtn = new JButton("ADD");
        addBtn.setBounds(140, 160, 80, 30);
        j.add(addBtn);
        addBtn.addActionListener(this);

        j.setSize(500, 500);
        j.setLayout(null);
        j.setVisible(true);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new JFrameLayout();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
//        JButton b = (JButton) e.getSource();
        String name = jTextField.getText();
        String add = jTextField2.getText();
        String tel = jTextField3.getText();
        SinhVienDAO sinhVienDAO = new SinhVienDAO();
        sinhVienDAO.create(name, add, tel);
        JOptionPane.showMessageDialog(j, "Successfully added");

        jTextField.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
    }
}
