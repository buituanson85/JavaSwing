/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment7.Dao;

import Assignment7.Model.Classs;
import Assignment7.Model.DataMrg;
import Assignment7.Model.ISchool;
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
public class ClassDAO {
    public static List<ISchool> findALl(){
        List<ISchool> isList = new ArrayList<>();
        Connection connection = DBConnection.openConnection();
        if(connection != null){
            Statement statement = null;
            try {
                String sql = "select * from classs";
                statement = connection.createStatement();
            
                ResultSet resultSet = statement.executeQuery(sql);
            
                while (resultSet.next()) {                
                    ISchool is = new Classs(
                            resultSet.getString("idClass"),
                            resultSet.getString("nameClass")
                    );
                    isList.add(is);
                }
            } catch (Exception e) {
            }finally{
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        DBConnection.closeConnection();
        return isList;
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
            } catch (Exception e) {
            }finally{
                if (preparedStatement != null) {
                    try {
                        preparedStatement.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            } catch (Exception e) {
            }finally{
                if (preparedStatement != null) {
                    try {
                        preparedStatement.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        DBConnection.closeConnection();
    }
    
    public static List<ISchool> searchByName(String _nameClass){
        List<ISchool> isList = new ArrayList<>();
        Connection connection = DBConnection.openConnection();
        
        if(connection != null){
            PreparedStatement preparedStatement = null;
            try {
                String sql = "EXEC search_class_by_name @nameClass = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%" + _nameClass + "%");

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {                
                    ISchool is = new Classs(
                            resultSet.getString("idClass"),
                            resultSet.getString("nameClass")
                    );
                    isList.add(is);
                }
            } catch (Exception e) {
            }finally{
                if (preparedStatement != null) {
                    try {
                        preparedStatement.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
         DBConnection.closeConnection();
        return isList;
    } 
}
