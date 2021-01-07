/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5;

import Lab4.dao.SinhVienDAO;
import Lab4.model.SinhVien;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Admin
 */
public class ListStudent {
    JFrame jFrame;

    public ListStudent() {
        jFrame = new JFrame("danh sách sinh viên");
        
        jFrame.setSize(400, 500);
        jFrame.setLayout(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        
        String header[] = {"Id", "Name", "Add", "Tel"};
        SinhVienDAO sinhVienDAO = new SinhVienDAO();
        
        List<SinhVien> sinhVienList = sinhVienDAO.findAll();
        String data[][] = new String[sinhVienList.size()][header.length];
        
        int count = 0;
        for (SinhVien sinhVien : sinhVienList) {
            data[count++][0] = String.valueOf(sinhVien.getId());
            data[count++][1] = sinhVien.getName();
            data[count++][2] = sinhVien.getAddress();
            data[count++][3] = sinhVien.getTel();
        }
        JTable table = new JTable();
        table.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(table);
        jFrame.add(sp);
        
        
    }
    public static void main(String[] args) {
        new ListStudent();
    }
    
}
