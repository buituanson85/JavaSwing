package Lab4.dao;

import Lab4.model.SinhVien;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SinhVienDAO {


    public List<SinhVien> findAll(){
        Connection connection = DBConnection.openConection();
        List<SinhVien> lsSV = new ArrayList<>();

        if (connection != null) {
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet =
                        statement.executeQuery("select * from SinhVien");

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

                    System.out.printf("%d %s %s %s, %n", id, name, address, tel);
                }
            } catch(SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        DBConnection.closeConection();
        return lsSV;
    }

    public List<SinhVien> findByName(String _name){
        Connection connection = DBConnection.openConection();
        List<SinhVien> lsSV = new ArrayList<>();

        if (connection != null) {
            PreparedStatement preparedStatement = null;
            try {
                String sql = "select * from SinhVien where name like ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%" + _name + "%");
                ResultSet resultSet =
                        preparedStatement.executeQuery();

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

//                    System.out.printf("%d %s %s %s, %n", id, name, address, tel);
                }
            } catch(SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        DBConnection.closeConection();
        return lsSV;
    }

    public void create(String name,String address,String tel){
        Connection connection = DBConnection.openConection();
        List<SinhVien> lsSV = new ArrayList<>();

        if (connection != null) {
            String insertSQL =
                    "insert into SinhVien(name, address, tel)  values (?, ?, ?)";
            PreparedStatement preparedStatement = null;
            try {
            preparedStatement = connection.prepareStatement(insertSQL);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, tel);
                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        DBConnection.closeConection();
    }

//    public void update(int id,String name,String address,String tel){
//        Connection connection = DBConnection.openConection();
//        PreparedStatement preparedStatement = null;
//        if (connection != null) {
//            try {
//                String updateSQL = "update SinhVien set name =  ?," +
//                        " address = ?, tel = ? where id = ?";
//                preparedStatement =
//                        connection.prepareStatement(updateSQL);
//                preparedStatement.setStoring(1, name);
//                preparedStatement.setString(2, address);
//                preparedStatement.setString(3, tel);
//                preparedStatement.setInt(4, id);
//                preparedStatement.executeUpdate();
//            }catch (Exception e){
//                e.getMessage();
//            }
//        }
//        DBConnection.closeConection();
//    }

    public void delete(int id){
        Connection connection = DBConnection.openConection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                String deleteSQL = "delete from SinhVien where id = ?";
                preparedStatement = connection.prepareStatement(deleteSQL);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        DBConnection.closeConection();
    }

    public void update(int _id, String __name, String _address, String _tel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
