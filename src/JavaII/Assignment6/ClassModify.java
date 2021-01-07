/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaII.Assignment6;

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
public class ClassModify {
    public static List<Classs> findALl(){
        List<Classs> classList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment5", "root", "");

            String sql = "select * from class";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Classs classs = new Classs(
                        resultSet.getInt("id_class"),
                        resultSet.getString("name_class"),
                        resultSet.getInt("age_class")
                );
                classList.add(classs);
            }
            
        } catch (Exception e) {
        }finally{
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClassModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClassModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return classList;
    }
    
    //hàm insert
    public static void insert(String name_class, String age_class){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment5", "root", "");
            
            String sql = "insert into class( name_class, age_class) values( ?, ?)";
            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name_class);
            preparedStatement.setString(1, age_class);
            preparedStatement.executeUpdate();
            System.out.println("Nhập thành công");
        } catch (Exception e) {
        }finally{
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClassModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClassModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    } 

}
