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
public class Classs {
    private int id_class;
    private String name_class;
    private int age_class;

    public Classs() {
    }

    public Classs(String name_class, int age_class) {
        this.name_class = name_class;
        this.age_class = age_class;
    }

    public Classs(int id_class, String name_class, int age_class) {
        this.id_class = id_class;
        this.name_class = name_class;
        this.age_class = age_class;
    }

    public int getId_class() {
        return id_class;
    }

    public void setId_class(int id_class) {
        this.id_class = id_class;
    }

    public String getName_class() {
        return name_class;
    }

    public void setName_class(String name_class) {
        this.name_class = name_class;
    }

    public int getAge_class() {
        return age_class;
    }

    public void setAge_class(int age_class) {
        this.age_class = age_class;
    }
    
    public static List<Classs> findALl(){
        List<Classs> classList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ass6", "root", "");
            
            String sql = "select * from classs";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                Classs classs = new Classs(
                        resultSet.getInt("idClass"),
                        resultSet.getString("nameClass"),
                        resultSet.getInt("ageClass")
                );
                classList.add(classs);
            }
            
        } catch (Exception e) {
        }finally{
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Classs.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Classs.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return classList;
    }
    
    public void create(String nameClass, int ageClass){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ass6", "root", "");
            String sql = "insert into classs( nameClass, ageClass) values( ?, ?)";
            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nameClass);
            preparedStatement.setInt(2, ageClass);
            preparedStatement.execute();
        } catch (Exception e) {
        }finally{
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Classs.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Classs.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public String toString() {
        return name_class;
    }
    
}
