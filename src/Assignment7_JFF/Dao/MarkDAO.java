
package Assignment7_JFF.Dao;

import Assignment7_JFF.Model.Mark;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MarkDAO {
    public static List<Mark> findAll(){
        Connection connection = DBConnection.openConnection();
        List<Mark> markList = new ArrayList<>();
        if (connection != null) {
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet =
                statement.executeQuery("select * from show_all_student");
                while (resultSet.next()) {
                    String nameClass = resultSet.getString("nameClass");
                    String idStudent = resultSet.getString("idStudent");
                    String nameStudent = resultSet.getString("nameStudent");
                    float pga = resultSet.getFloat("pga");
                    String nameSub = resultSet.getString("nameSub");
                    String nameSem = resultSet.getString("nameSem");
                    String date = resultSet.getString("dateSem");
                    Mark mark = new Mark();
                    
                    mark.setIdStudent(idStudent);
                    mark.setNameClass(nameClass);
                    mark.setNameStudent(nameStudent);
                    mark.setPga(pga);
                    mark.setNameSub(nameSub);
                    mark.setNameSem(nameSem);
                    mark.setDateSem(date);
                    markList.add(mark);
                }
            } catch(SQLException throwables) {
            }
        }
        DBConnection.closeConnection();
        return markList;
    }
    
    public static void inputInto(String idStudent, String idSub, String idSem, float pga){
        Connection connection = DBConnection.openConnection();
        if (connection != null) {
            PreparedStatement preparedStatement = null;
            try {
                String sql = "EXEC insert_into_mark @idStudent = ?, @idSub = ?, @idSem = ?, @pga = ?";
            
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, idStudent);
                preparedStatement.setString(2, idSub);
                preparedStatement.setString(3, idSem);
                preparedStatement.setFloat(4, pga);
                preparedStatement.execute();
            } catch (SQLException e) {
            }finally{
                if (preparedStatement != null) {
                    try {
                        preparedStatement.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(MarkDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
    public static List<Mark> searchById(String _idStudent){
        List<Mark> markList = new ArrayList<>();
        Connection connection = DBConnection.openConnection();
        
        if(connection != null){
            PreparedStatement preparedStatement = null;
            try {
                String sql = "EXEC search_mark @idStudent = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%" + _idStudent + "%");

                ResultSet resultSet = preparedStatement.executeQuery();
                
                while (resultSet.next()) {                
                    String nameClass = resultSet.getString("nameClass");
                    String idStudent = resultSet.getString("idStudent");
                    String nameStudent = resultSet.getString("nameStudent");
                    float pga = resultSet.getFloat("pga");
                    String nameSub = resultSet.getString("nameSub");
                    String nameSem = resultSet.getString("nameSem");
                    String date = resultSet.getString("dateSem");
                    Mark mark = new Mark();
                    
                    mark.setIdStudent(idStudent);
                    mark.setNameClass(nameClass);
                    mark.setNameStudent(nameStudent);
                    mark.setPga(pga);
                    mark.setNameSub(nameSub);
                    mark.setNameSem(nameSem);
                    mark.setDateSem(date);
                    markList.add(mark);
                }
            } catch (SQLException e) {
            }finally{
                if (preparedStatement != null) {
                    try {
                        preparedStatement.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
         DBConnection.closeConnection();
        return markList;
    } 
    public static void delete(String id){
        Connection connection = DBConnection.openConnection();
        if (connection != null) {
            PreparedStatement preparedStatement = null;
            try {
                String sql = "EXEC delete_mark_by_idStudents @idStudent = ?";
            
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, id);
                preparedStatement.execute();
            } catch (SQLException e) {
            }finally{
                if (preparedStatement != null) {
                    try {
                        preparedStatement.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        DBConnection.closeConnection();
    }
}
