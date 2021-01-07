package qlsinhvien.swingdemo;

import qlsinhvien.dao.SinhVienDAO;
import qlsinhvien.model.SinhVien;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class ListSinhVien extends JFrame {
    JFrame j;
    public ListSinhVien() throws SQLException {
        j = new JFrame();
//        String header[]= {"ID", "Name", "Add", "Tel"};
//        SinhVienDAO sinhVienDAO = new SinhVienDAO();
//        List<SinhVien> lsSV = sinhVienDAO.findAll();
//        String data[][] = new String[lsSV.size()][header.length];
//        int count = 0;
//        for(SinhVien sv:lsSV){
//            data[count][0] = String.valueOf(sv.getId());
//            data[count][1] = sv.getName();
//            data[count][2] = sv.getAddress();
//            data[count][3] = sv.getTel();
//            count++;
//        }
//        JTable jTable = new JTable(data, header);
//        jTable.setBounds(30,30, 350, 400);
//        j.add(jTable);

        ListSinhVienModel model = new ListSinhVienModel();
        JTable table = new JTable(model);
        table.setBounds(30, 40,200,300);
        JScrollPane sp = new JScrollPane(table);
        j.add(sp);

        j.setSize(500, 500);
//        j.setLayout(null);
        j.setVisible(true);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws SQLException {
        new ListSinhVien();
    }

}
