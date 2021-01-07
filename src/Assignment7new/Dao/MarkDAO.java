/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment7new.Dao;

import Assignment7new.Model.Mark;
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
    public static void insertProduct(String idStudent, String idSub, String idSem, float pga){
          Connection connection = DBConnection.openConnection();
          if (connection != null) {
            PreparedStatement preparedStatement = null;
              try {
                String sql = "insert into mark( idStudent, idSub, idSem, pga) values( ?, ?, ?, ?)";

                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, idStudent);
                    preparedStatement.setString(2, idSub);
                    preparedStatement.setString(3, idSem);
                    preparedStatement.setString(4, String.valueOf(pga));
                    preparedStatement.execute();

                    System.out.println("Nhập thành công");
              } catch (Exception e) {
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
    
    public static List<Mark> findAll(){
        Connection connection = DBConnection.openConnection();
        List<Mark> markList = new ArrayList<>();
        if (connection != null) {
            Statement statement = null;
            try {
                String sql = "select * from show_Mark_Student_View";
                statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {                
                    Mark mark = new Mark(
                            resultSet.getString("idStudent"),
                            resultSet.getString("nameStudent"),
                            resultSet.getString("nameClass"),
                            resultSet.getFloat("pga"),
                            resultSet.getString("idSub"),
                            resultSet.getString("idSem")
                    );
                    markList.add(mark);
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
        return markList;
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
    
    public static List<Mark> searchByName(String _nameStudent){
        List<Mark> markList = new ArrayList<>();
        Connection connection = DBConnection.openConnection();
        
        if(connection != null){
            PreparedStatement preparedStatement = null;
            try {
                String sql = "select * from show_Mark_Student_View where idStudent like ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%" + _nameStudent + "%");

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {                
                    Mark mark = new Mark(
                            resultSet.getString("idStudent"),
                            resultSet.getString("nameStudent"),
                            resultSet.getString("nameClass"),
                            resultSet.getFloat("pga"),
                            resultSet.getString("idSub"),
                            resultSet.getString("idSem")
                    );
                    markList.add(mark);
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
        return markList;
    } 
}
