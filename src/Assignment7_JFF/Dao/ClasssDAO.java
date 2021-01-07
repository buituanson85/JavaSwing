
package Assignment7_JFF.Dao;

import Assignment7_JFF.Model.Classs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClasssDAO {
    public static List<Classs> findALl(){
        List<Classs> classList = new ArrayList<>();
        Connection connection = DBConnection.openConnection();
        if(connection != null){
            Statement statement = null;
            try {
                String sql = "select * from classs";
                statement = connection.createStatement();
            
                ResultSet resultSet = statement.executeQuery(sql);
            
                while (resultSet.next()) {                
                    Classs classs = new Classs(
                            resultSet.getString("idClass"),
                            resultSet.getString("nameClass")
                    );
                    classList.add(classs);
                }
            } catch (SQLException e) {
            }finally{
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(ClasssDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        DBConnection.closeConnection();
        return classList;
    }
    
    public static void create(String idClass, String nameClass){
        Connection connection = DBConnection.openConnection();
        if (connection != null) {
            PreparedStatement preparedStatement = null;
            try {
                String sql = "EXEC insert_into_class @idClass = ?, @nameClass = ?";
            
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, idClass);
                preparedStatement.setString(2, nameClass);
                preparedStatement.execute();
            } catch (SQLException e) {
            }finally{
                if (preparedStatement != null) {
                    try {
                        preparedStatement.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(ClasssDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
    
    public static void delete(String id){
        Connection connection = DBConnection.openConnection();
        if (connection != null) {
            PreparedStatement preparedStatement = null;
            try {
                String sql = "EXEC delete_class_by_id @idClass = ?";
            
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, id);
                preparedStatement.execute();
            } catch (SQLException e) {
            }finally{
                if (preparedStatement != null) {
                    try {
                        preparedStatement.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(ClasssDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        DBConnection.closeConnection();
    }
    
    public static List<Classs> searchByName(String _nameClass){
        List<Classs> classList = new ArrayList<>();
        Connection connection = DBConnection.openConnection();
        
        if(connection != null){
            PreparedStatement preparedStatement = null;
            try {
                String sql = "EXEC search_class_by_name @nameClass = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%" + _nameClass + "%");

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {                
                    Classs classs = new Classs(
                            resultSet.getString("idClass"),
                            resultSet.getString("nameClass")
                    );
                    classList.add(classs);
                }
            } catch (SQLException e) {
            }finally{
                if (preparedStatement != null) {
                    try {
                        preparedStatement.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(ClasssDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
         DBConnection.closeConnection();
        return classList;
    }
}

/*public void create(int age, int yearborn,String c_name, String name, String gender, String Hland, String tel){
        Connection connection =  StudentManager.dao.DBConnection.openConnection();
        int c_id = 0;
        if(connection!= null){
            try {
                PreparedStatement p1 = connection.prepareStatement("Select * from Class where C_Name like ?");
                p1.setString(1,"%"+c_name+"%");
                ResultSet rs = p1.executeQuery();
                if(rs.next()) {
                     c_id = rs.getInt("C_ID");
                }

                String insertSQL = "insert into Student(S_Age,S_YBorn,C_ID,S_Name,S_Gender,S_HLand,S_Tel) values(?,?,?,?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
                preparedStatement.setInt(1,age); //cái parameterIndex tương ứng với từng cái ?
                preparedStatement.setInt(2,yearborn);
                preparedStatement.setInt(3, c_id);
                preparedStatement.setString(4,name);
                preparedStatement.setString(5,gender);
                preparedStatement.setString(6,Hland);
                preparedStatement.setString(7,tel);
                preparedStatement.executeUpdate();
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }

        }
        DBConnection.closeConnection();
    }*/