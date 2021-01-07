/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_7.DAO;

import Assignment_7.Controller.DataMrg;
import Assignment_7.Model.Semester;
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
    public static List<Semester> findAll(){
        Connection connection = DBConnection.openConnection();
        List<Semester> semeterList = DataMrg.getInstance().getSemesterList();

        if (connection != null) {
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet =
                        statement.executeQuery("select * from semester");

                while (resultSet.next()) {
                    String id = resultSet.getString("idSem");
                    String name = resultSet.getString("nameSem");
                    String date = resultSet.getString("dateSem");

                    Semester semeter = new Semester();
                    semeter.setId(id);
                    semeter.setName(name);
                    semeter.setDateSem(date);
                    semeterList.add(semeter);

                    semeter.display();
                }
            } catch(SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        DBConnection.closeConnection();
        return semeterList;
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
            } catch (Exception e) {
            }finally{
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
