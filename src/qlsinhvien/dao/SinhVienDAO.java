package qlsinhvien.dao;

import qlsinhvien.model.SinhVien;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SinhVienDAO {
    public List<SinhVien> findAll() throws SQLException {
        Connection connection = DBConnection.openConnection();
        List<SinhVien> lsSV = new ArrayList<SinhVien>();
        if(connection != null){
            Statement statement;
            try{
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("Select * From SinhVien");
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String address = resultSet.getString("address");
                    String tel = resultSet.getString("tel");
                    SinhVien sv = new SinhVien();
                    sv.setId(id);
                    sv.setName(name);
                    sv.setAddress(address);
                    sv.setTel(tel);
                    lsSV.add(sv);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        DBConnection.closeConnection();
        return lsSV;
    }



    public List<SinhVien> findByName(String _name) throws SQLException {
        Connection connection = DBConnection.openConnection();
        List<SinhVien> lsSV = new ArrayList<SinhVien>();
        if(connection != null){
            PreparedStatement preparedStatement = null;
            try{

                String sql = "Select * From SinhVien where name like ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%" + _name + "%");
                ResultSet resultSet =preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String address = resultSet.getString("address");
                    String tel = resultSet.getString("tel");
                    SinhVien sv = new SinhVien();
                    sv.setId(id);
                    sv.setName(name);
                    sv.setAddress(address);
                    sv.setTel(tel);
                    lsSV.add(sv);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        DBConnection.closeConnection();
        return lsSV;
    }

    public void create(String name, String address, String tel){
        Connection connection = DBConnection.openConnection();
        if(connection != null){

            PreparedStatement preparedStatement = null;
            try {
                String insertsql = "insert into SinhVien Values (?, ?, ?)";
                preparedStatement = connection.prepareStatement(insertsql);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, address);
                preparedStatement.setString(3, tel);
                preparedStatement.executeUpdate();
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        DBConnection.closeConnection();
    }

    public void update(int id, String name, String address, String tel){
        Connection connection = DBConnection.openConnection();
        if(connection != null) {
            PreparedStatement preparedStatement = null;
            try{
                String updateSQL = "UPDATE SinhVien set name = ?, address = ?, tel = ? where id = ?";
                preparedStatement = connection.prepareStatement(updateSQL);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, address);
                preparedStatement.setString(3, tel);
                preparedStatement.setInt(4, id);
                preparedStatement.executeUpdate();
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
    }

    public void delete(int id){
        Connection connection = DBConnection.openConnection();
        if(connection != null){
            PreparedStatement preparedStatement = null;
            try{
                String deleteSQL = "DELETE FROM SinhVien WHERE id = ?";
                preparedStatement = connection.prepareStatement(deleteSQL);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();

            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
    }
}
