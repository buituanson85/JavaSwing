/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment7new.Dao;

import Assignment7new.Model.Semester;
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
public class SemesterDAO {
    public static List<Semester> findALl(){
        List<Semester> semesterList = new ArrayList<>();
        Connection connection = DBConnection.openConnection();
        if(connection != null){
            Statement statement = null;
            try {
                String sql = "select * from semester";
                statement = connection.createStatement();
            
                ResultSet resultSet = statement.executeQuery(sql);
            
                while (resultSet.next()) {                
                    Semester semester = new Semester(
                            resultSet.getString("idSem"),
                            resultSet.getString("nameSem"),
                            resultSet.getString("dateSem")
                    );
                    semesterList.add(semester);
                }
            } catch (Exception e) {
            }finally{
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        DBConnection.closeConnection();
        return semesterList;
    }
    
    public static void create(String idSem, String nameSem,String dateSem){
        Connection connection = DBConnection.openConnection();
        if (connection != null) {
            PreparedStatement preparedStatement = null;
            try {
                String sql = "insert into semester( idSem, nameSem, dateSem) values( ?, ?, ?)";
            
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, idSem);
                preparedStatement.setString(2, nameSem);
                preparedStatement.setString(3, dateSem);
                preparedStatement.execute();
            } catch (Exception e) {
            }finally{
                if (preparedStatement != null) {
                    try {
                        preparedStatement.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                String sql = "delete from semester where idSem = ?";
            
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, id);
                preparedStatement.execute();
            } catch (Exception e) {
            }finally{
                if (preparedStatement != null) {
                    try {
                        preparedStatement.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        DBConnection.closeConnection();
    }
    
    public static List<Semester> searchByName(String _nameSem){
        List<Semester> semesterList = new ArrayList<>();
        Connection connection = DBConnection.openConnection();
        
        if(connection != null){
            PreparedStatement preparedStatement = null;
            try {
                String sql = "select * from semester where nameSem like ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%" + _nameSem + "%");

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {                
                    Semester semester = new Semester(
                            resultSet.getString("idSem"),
                            resultSet.getString("nameSem"),
                            resultSet.getString("dateSem")
                    );
                    semesterList.add(semester);
                }
            } catch (Exception e) {
            }finally{
                if (preparedStatement != null) {
                    try {
                        preparedStatement.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
         DBConnection.closeConnection();
        return semesterList;
    } 
}
