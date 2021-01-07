/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment6;

import java.sql.Connection;
import java.sql.DriverManager;
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
    
    public static void insertProduct(String  nameStudent, int ageStudent,int idClass) throws SQLException{
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
                      preparedStatement.close();
                  }
              }
        }
        DBConnection.closeConnection();
    }
    
    public static List<Students> findAll() throws SQLException{
        Connection connection = DBConnection.openConnection();
        List<Students> studentsList = new ArrayList<>();
        if (connection != null) {
            Statement statement = null;
            try {
                String sql = "select student.*, classs.idClass, classs.nameClass from student, classs where student.idClass = classs.idClass";
                statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {                
                    Students students = new Students(
                            resultSet.getInt("idStudent"),
                            resultSet.getString("nameStudent"),
                            resultSet.getInt("ageStudent"),
                            resultSet.getString("nameClass"),
                            resultSet.getInt("idClass")
                    );
                    studentsList.add(students);
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                if (statement != null) {
                    statement.close();
                }
            }
        }
        DBConnection.closeConnection();
        return studentsList;
    }
}


// Connection connection = null;
//        Statement statement = null;
//        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ass6", "root", "");
//            
//            String sql = "select student.*, classs.idClass, classs.nameClass from student, classs where student.idClass = classs.idClass";
//            
//            statement = connection.createStatement();
//            
//            ResultSet resultSet = statement.executeQuery(sql);
//            
//            while (resultSet.next()) {                
//                Students students = new Students(
//                        resultSet.getInt("idStudent"),
//                        resultSet.getString("nameStudent"),
//                        resultSet.getInt("ageStudent"),
//                        resultSet.getString("nameClass"),
//                        resultSet.getInt("idClass")
//                );
//                studentsList.add(students);
//            }
//        } catch (Exception e) {
//        }finally{
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                
//            }
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }

        
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ass6", "root", "");
//            
//            String sql = "insert into student( nameStudent, ageStudent, idClass) values( ?, ?, ?)";
//            
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, nameStudent);
//            preparedStatement.setString(2, String.valueOf(ageStudent));
//            preparedStatement.setString(3, String.valueOf(idClass));
//            preparedStatement.execute();
//            
//            System.out.println("Nhập thành công");
//        } catch (Exception e) {
//        }finally{
//            if (preparedStatement != null) {
//                try {
//                    preparedStatement.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }