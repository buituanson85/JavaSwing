/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package THFrame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
public class StudentModify {
    
    public static List<Student> findAll(){
        // hàm lấy ra tất cả danh sách sinh viên
        List<Student> studentList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
            String findSQL = "select * from student";
            
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(findSQL);
            
            while (resultSet.next()) {                
                Student student = new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("fullName"),
                        resultSet.getString("gender"), 
                        resultSet.getInt("age"),
                        resultSet.getString("email"), 
                        resultSet.getString("phone"));
                studentList.add(student);
            }
        } catch (Exception e) {
        }finally{
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //keets thucs
        return studentList;
    }
    
    public static void insert(Student student){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
            String insertSQL = "insert into student( fullName, gender, age, email, phone) values( ?, ?, ?, ?, ?)";
            
            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, student.getFullName());
            preparedStatement.setString(2, student.getGender());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setString(5, student.getPhoneNumber());
            
            preparedStatement.execute();
            System.out.println("Luwu thanh cong");
        } catch (Exception e) {
        }finally{
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void update(Student student){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
            String updateSQL = "update student set fullName = ?, gender = ?, age = ?, email = ?, phone = ? where id = ?";
            
            preparedStatement = connection.prepareStatement(updateSQL);
            
            preparedStatement.setString(1, student.getFullName());
            preparedStatement.setString(2, student.getGender());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setString(5, student.getPhoneNumber());
            preparedStatement.setInt(6, student.getId());
            
            preparedStatement.execute();
            System.out.println("update thanh cong");
        } catch (Exception e) {
        }finally{
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
    public static void delete(int id){
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
            
            String deleteSQL = "delete from student where id = ?";
            
            preparedStatement = connection.prepareStatement(deleteSQL);
            
            preparedStatement.setInt(1, id);
            
            preparedStatement.execute();
            System.out.println("delete thanh cong");
        } catch (Exception e) {
        }finally{
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public  static List<Student> searchByName(String fullName){
        List<Student> studentList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        //những câu truy vấn nào có dữ liệu đưa từ msql vào thì ta dùng PreparedStatement
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
            
            String searchSQL = "select * from student where fullName like ?";
            
            preparedStatement = connection.prepareStatement(searchSQL);
            preparedStatement.setString(1, "%" + fullName + "%");
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Student student = new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("fullName"),
                        resultSet.getString("gender"),
                        resultSet.getInt("age"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"));
                studentList.add(student);
            }
        } catch (Exception e) {
        }finally{
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return studentList;
    }
    
    public static List<Student> saveInfoToTextFile(){
        List<Student> studentList = new ArrayList<>();
        
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("D:\\JavaSwing\\JavaSwing\\src\\THFrame\\student.dat");
            oos = new ObjectOutputStream(fos);
            
            oos.writeObject(studentList);
        } catch (Exception e) {
        }finally{
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
             if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return studentList;
    } 
}
