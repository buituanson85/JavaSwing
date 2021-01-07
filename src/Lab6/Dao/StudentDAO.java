/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab6.Dao;

import Lab6.Controller.StudentJFrame;
import Lab6.Controller.StudentListJFrame;
import Lab6.Model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class StudentDAO {
    
    public static void insertProduct(String  nameStudent, int ageStudent,int idClass){
          Connection connection = DBConnection.openConnection();
          if (connection != null) {
            PreparedStatement preparedStatement = null;
              try {
                    String sql = "insert into student( nameStudent, ageStudent, idClass) values( ?, ?, ?)";

                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, nameStudent);
                    preparedStatement.setString(2, String.valueOf(ageStudent));
                    preparedStatement.setString(3, String.valueOf(idClass));
                    preparedStatement.execute();

                    System.out.println("Nhập thành công");
              } catch (Exception e) {
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
        Connection connection = DBConnection.openConnection();
        List<Student> studentList = new ArrayList<>();
        if (connection != null) {
            Statement statement = null;
            try {
                String sql = "select student.*, classs.idClass, classs.nameClass from student, classs where student.idClass = classs.idClass";
                statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {                
                    Student student = new Student(
                            resultSet.getInt("idStudent"),
                            resultSet.getString("nameStudent"),
                            resultSet.getInt("ageStudent"),
                            resultSet.getInt("idClass"),
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
    
    public static void delete(int id){
        Connection connection = DBConnection.openConnection();
        if (connection != null) {
            PreparedStatement preparedStatement = null;
            try {
                String sql = "delete from student where idStudent = ?";
            
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                preparedStatement.execute();
            } catch (Exception e) {
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
                String sql = "select classs.idClass, classs.nameClass , student.* from student"
                                + " INNER JOIN classs ON classs.idClass = student.idClass"
                                + "  where student.nameStudent like ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%" + _nameStudent + "%");

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {                
                    Student student = new Student(
                            resultSet.getInt("idStudent"),
                            resultSet.getString("nameStudent"),
                            resultSet.getInt("ageStudent"),
                            resultSet.getInt("idClass"),
                            resultSet.getString("nameClass")
                    );
                    studentList.add(student);
                }
            } catch (Exception e) {
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
    
    //Hàm update viết ở file studentJFrame
}
