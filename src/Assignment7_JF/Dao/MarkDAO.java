/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment7_JF.Dao;

import Assignment7_JF.Model.ISchool;
import Assignment7_JF.Model.Mark;
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
public class MarkDAO {
    public static void insert(String idStudent, String idSub, String idSem, float pga){
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
                    preparedStatement.executeUpdate();

                    System.out.println("Nhập thành công");
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
        DBConnection.closeConnection();
    }
    
    public static List<ISchool> findAll(){
        Connection connection = DBConnection.openConnection();
        List<ISchool> isList = new ArrayList<>();
        if (connection != null) {
            Statement statement = null;
            try {
                String sql = "SELECT * FROM showStudent_View";
                statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {                
                    ISchool is = new Mark(
                            resultSet.getString("nameClass"),
                            resultSet.getString("idStudent"),
                            resultSet.getString("nameStudent"),
                            resultSet.getFloat("pga"),
                            resultSet.getString("idSub"),
                            resultSet.getString("idSem")
                    );
                    isList.add(is);
                }
            } catch (SQLException ex) {
                Logger.getLogger(MarkDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(MarkDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        DBConnection.closeConnection();
        return isList;
    }
    
    public static void delete(String id){
        Connection connection = DBConnection.openConnection();
        if (connection != null) {
            PreparedStatement preparedStatement = null;
            try {
                String sql = "delete from mark where idStudent = ?";
            
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
    
    public static List<ISchool> searchById(String _idStudent){
        List<ISchool> isList = new ArrayList<>();
        Connection connection = DBConnection.openConnection();
        
        if(connection != null){
            PreparedStatement preparedStatement = null;
            try {
                String sql = "EXEC search_mart_by_id @idStudent = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%" + _idStudent + "%");

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {                
                    ISchool is = new Mark(
                            resultSet.getString("nameClass"),
                            resultSet.getString("idStudent"),
                            resultSet.getString("nameStudent"),
                            resultSet.getFloat("pga"),
                            resultSet.getString("idSub"),
                            resultSet.getString("idSem")
                    );
                    isList.add(is);
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
        return isList;
    } 
}
