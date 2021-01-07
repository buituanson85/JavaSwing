
package Assignment7_JFF.Dao;

import Assignment7_JFF.Model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDAO {
    public static void insert(String idStudent, String  nameStudent, int ageStudent, String dateStudent, String genderStudent, String addressStudent,
            String phoneStudent, String idClass){
          Connection connection = DBConnection.openConnection();
          if (connection != null) {
            PreparedStatement preparedStatement = null;
              try {
                String sql = "EXEC insert_student_by_id @idStudent = ?, @nameStudent = ?, @ageStudent = ?, @dateStudent = ?, @genderStudent = ?,"
                        + " @addressStudent = ?, @phoneStudent = ?, @idClass = ?";

                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, idStudent);
                    preparedStatement.setString(2, nameStudent);
                    preparedStatement.setInt(3, ageStudent);
                    preparedStatement.setString(4, dateStudent);
                    preparedStatement.setString(5, genderStudent);
                    preparedStatement.setString(6, addressStudent);
                    preparedStatement.setString(7, phoneStudent);
                    preparedStatement.setString(8, idClass);
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
    
    public static List<Student> findAll(){
        List<Student> studentList = new ArrayList<>();
        
        Connection connection = DBConnection.openConnection();
        if (connection != null) {
            Statement statement = null;
            try {
                String sql = "select * from view_student";
                statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {                
                    Student student = new Student(
                            resultSet.getString("idStudent"),
                            resultSet.getString("nameStudent"),
                            resultSet.getInt("ageStudent"),
                            resultSet.getString("dateStudent"),
                            resultSet.getString("genderStudent"),
                            resultSet.getString("addressStudent"),
                            resultSet.getString("phoneStudent"),
                            resultSet.getString("nameClass")
                    );
                    studentList.add(student);
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        DBConnection.closeConnection();
        return studentList;
    }
    
    public static void delete(String id){
        Connection connection = DBConnection.openConnection();
        if (connection != null) {
            PreparedStatement preparedStatement = null;
            try {
                String sql = "EXEC delete_student_by_id @idStudent = ?";
            
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
    
    public static List<Student> searchByName(String _nameStudent){
        List<Student> studentList = new ArrayList<>();
        Connection connection = DBConnection.openConnection();
        
        if(connection != null){
            PreparedStatement preparedStatement = null;
            try {
                String sql = "EXEC search_student_byname @nameStudent = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%" + _nameStudent + "%");

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {                
                    Student student = new Student(
                            resultSet.getString("idStudent"),
                            resultSet.getString("nameStudent"),
                            resultSet.getInt("ageStudent"),
                            resultSet.getString("dateStudent"),
                            resultSet.getString("genderStudent"),
                            resultSet.getString("addressStudent"),
                            resultSet.getString("phoneStudent"),
                            resultSet.getString("idClass"),
                            resultSet.getString("nameClass")
                    );
                    studentList.add(student);
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
        return studentList;
    } 
}
