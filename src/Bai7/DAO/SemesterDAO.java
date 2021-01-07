/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai7.DAO;

import Bai7.Model.Semester;
import Bai7.Controller.DataMrg;
import Bai7.Model.ISchool;
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
public class SemesterDAO {
    public static List<ISchool> findAll(){
        Connection connection = DBConnection.openConnection();
        List<ISchool> iiopList = DataMrg.getInstance().getiSchoolList();
        if (connection != null) {
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet =
                statement.executeQuery("select * from semester");
                System.out.printf("%-20s %-20s %-20s", "Id", "Name", "dateSem");
                System.out.println("");
                while (resultSet.next()) {
                    String id = resultSet.getString("idSem");
                    String name = resultSet.getString("nameSem");
                    String date = resultSet.getString("dateSem");
                    Semester semester = new Semester();
                    
                    semester.setId(id);
                    semester.getSemString();
                    semester.setDateSem(date);
                    DataMrg.getInstance().getiSchoolList().add(semester);

                    semester.display();
                }
            } catch(SQLException throwables) {
            }
        }
        DBConnection.closeConnection();
        return DataMrg.getInstance().getiSchoolList();
    }
    
    public static void inputInto(String idSem, String nameSem, String dateSem){
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
            } catch (SQLException e) {
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
}
