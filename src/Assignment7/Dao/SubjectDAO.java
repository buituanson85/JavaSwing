/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment7.Dao;

import Assignment7.Model.DataMrg;
import Assignment7.Model.ISchool;
import Assignment7.Model.Subject;
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
public class SubjectDAO{
    public static List<ISchool> findALl(){
        List<ISchool> isList = new ArrayList<>();
        Connection connection = DBConnection.openConnection();
        if(connection != null){
            Statement statement = null;
            try {
                String sql = "select * from subject";
                statement = connection.createStatement();
            
                ResultSet resultSet = statement.executeQuery(sql);
            
                while (resultSet.next()) {                
                    ISchool is = new Subject(
                            resultSet.getString("idSub"),
                            resultSet.getString("nameSub")
                    );
                    isList.add(is);
                }
            } catch (Exception e) {
            }finally{
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        DBConnection.closeConnection();
        return isList;
    }
    
    public static void create(String idSub, String nameSub){
        Connection connection = DBConnection.openConnection();
        if (connection != null) {
            PreparedStatement preparedStatement = null;
            try {
                String sql = "insert into subject( idSub, nameSub) values( ?, ?)";
            
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, idSub);
                preparedStatement.setString(2, nameSub);
                preparedStatement.execute();
            } catch (Exception e) {
            }finally{
                if (preparedStatement != null) {
                    try {
                        preparedStatement.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                String sql = "delete from subject where idSub = ?";
            
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, id);
                preparedStatement.execute();
            } catch (Exception e) {
            }finally{
                if (preparedStatement != null) {
                    try {
                        preparedStatement.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        DBConnection.closeConnection();
    }
    
    public static List<ISchool> searchByName(String _nameSub){
        List<ISchool> isList = new ArrayList<>();
        Connection connection = DBConnection.openConnection();
        
        if(connection != null){
            PreparedStatement preparedStatement = null;
            try {
                String sql = "select * from subject where nameSub like ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%" + _nameSub + "%");

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {                
                    ISchool is = new Subject(
                            resultSet.getString("idSub"),
                            resultSet.getString("nameSub")
                    );
                    isList.add(is);
                }
            } catch (Exception e) {
            }finally{
                if (preparedStatement != null) {
                    try {
                        preparedStatement.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
         DBConnection.closeConnection();
        return isList;
    } 
}
