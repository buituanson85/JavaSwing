/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai7.DAO;

import Bai7.Controller.DataMrg;
import Bai7.Model.ISchool;
import Bai7.Model.Mark;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class MarkDAO {
    public static List<ISchool> findAll(){
        Connection connection = DBConnection.openConnection();
        List<ISchool> iiopList = DataMrg.getInstance().getiSchoolList();
        if (connection != null) {
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet =
                statement.executeQuery("select * from show_all_student");
                System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s", "nameClass", "idStudent", "nameStudent", "pga", "nameSub", "nameSem", "dateSem");
                System.out.println("");
                while (resultSet.next()) {
                    String nameClass = resultSet.getString("nameClass");
                    String idStudent = resultSet.getString("idStudent");
                    String nameStudent = resultSet.getString("nameStudent");
                    float pga = resultSet.getFloat("pga");
                    String nameSub = resultSet.getString("nameSub");
                    String nameSem = resultSet.getString("nameSem");
                    String date = resultSet.getString("dateSem");
                    Mark mark = new Mark();
                    
                    mark.setIdStudent(idStudent);
                    mark.setNameClass(nameClass);
                    mark.setNameStudent(nameStudent);
                    mark.setPga(pga);
                    mark.setNameSub(nameSub);
                    mark.setNameSem(nameSem);
                    mark.setDateSem(date);
                    DataMrg.getInstance().getiSchoolList().add(mark);

                    
                    mark.display();
                }
            } catch(SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        DBConnection.closeConnection();
        return DataMrg.getInstance().getiSchoolList();
    }
    
    public static void inputInto(String idStudent, String idSub, String idSem, float pga){
        Connection connection = DBConnection.openConnection();
        if (connection != null) {
            PreparedStatement preparedStatement = null;
            try {
                String sql = "EXEC insert_into_mark @idStudent = ?, @idSub = ?, @idSem = ?, @pga = ?";
            
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, idStudent);
                preparedStatement.setString(2, idSub);
                preparedStatement.setString(3, idSem);
                preparedStatement.setString(4, String.valueOf(pga));
                preparedStatement.execute();
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
    }
    public static List<ISchool> searchById(String _idStudent){
        List<ISchool> isList = DataMrg.getInstance().getiSchoolList();
        Connection connection = DBConnection.openConnection();
        
        if(connection != null){
            PreparedStatement preparedStatement = null;
            try {
                String sql = "EXEC search_mark @idStudent = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%" + _idStudent + "%");

                ResultSet resultSet = preparedStatement.executeQuery();
                System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s", "nameClass", "idStudent", "nameStudent", "pga", "nameSub", "nameSem", "dateSem");
                while (resultSet.next()) {                
                    String nameClass = resultSet.getString("nameClass");
                    String idStudent = resultSet.getString("idStudent");
                    String nameStudent = resultSet.getString("nameStudent");
                    float pga = resultSet.getFloat("pga");
                    String nameSub = resultSet.getString("nameSub");
                    String nameSem = resultSet.getString("nameSem");
                    String date = resultSet.getString("dateSem");
                    Mark mark = new Mark();
                    
                    mark.setIdStudent(idStudent);
                    mark.setNameClass(nameClass);
                    mark.setNameStudent(nameStudent);
                    mark.setPga(pga);
                    mark.setNameSub(nameSub);
                    mark.setNameSem(nameSem);
                    mark.setDateSem(date);
                    DataMrg.getInstance().getiSchoolList().add(mark);

                    mark.display();
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
