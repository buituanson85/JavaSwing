/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaII.Assignment6;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class ListClassModel extends AbstractTableModel{
    List<Classs> classList = new ArrayList<Classs>();
    String header[] = {"ID", "Name", "Age"};

    public ListClassModel() throws SQLException {
        ClassModify classModify = new ClassModify();
       classList = classModify.findALl();
    }

    @Override
    public int getRowCount() {
        return classList.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Classs classs = classList.get(rowIndex);
        String values = "";
        switch(columnIndex){
            case 0:
                values = String.valueOf(classs.getId_class());
                break;
            case 1:
                values = classs.getName_class();
                break;
            case 2:
                values = String.valueOf(classs.getAge_class());
        }
        return values;
    }
     public String getColumnName(int column){
        return header[column];
    }
}
