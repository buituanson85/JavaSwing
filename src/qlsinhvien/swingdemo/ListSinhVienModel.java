package qlsinhvien.swingdemo;

import qlsinhvien.dao.SinhVienDAO;
import qlsinhvien.model.SinhVien;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListSinhVienModel extends AbstractTableModel {
    List<SinhVien> lsSV = new ArrayList<SinhVien>();
    String header[] = {"ID", "Name", "Address", "Tel"};

    public ListSinhVienModel() throws SQLException {
        SinhVienDAO sinhVienDAO = new SinhVienDAO();
        lsSV = sinhVienDAO.findAll();
    }
    @Override
    public int getRowCount() {
        return lsSV.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SinhVien sv = lsSV.get(rowIndex);
        String value = "";
        switch (columnIndex){
            case 0:
                value = String.valueOf(sv.getId());
                break;
            case 1:
                value = sv.getName();
                break;
            case 2:
                value = sv.getAddress();
                break;
            case 3:
                value = sv.getTel();
                break;
        }
        return value;
    }

    public String getColumnName(int column){
        return header[column];
    }
}
