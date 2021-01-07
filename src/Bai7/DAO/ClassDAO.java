/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai7.DAO;

import Bai7.Model.Classs;
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
public class ClassDAO {
    public static List<ISchool> findAll(){
        Connection connection = DBConnection.openConnection();
        List<ISchool> iiopList = DataMrg.getInstance().getiSchoolList();
        if (connection != null) {
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet =
                statement.executeQuery("select * from classs");
                System.out.printf("%-20s %-20s", "Id", "Name");
                System.out.println("");
                while (resultSet.next()) {
                    String id = resultSet.getString("idClass");
                    String name = resultSet.getString("nameClass");

                    Classs classs = new Classs();
                    
                    classs.setId(id);
                    classs.setName(name);
                    DataMrg.getInstance().getiSchoolList().add(classs);

                    classs.display();
                }
            } catch(SQLException throwables) {
            }
        }
        DBConnection.closeConnection();
        return DataMrg.getInstance().getiSchoolList();
    }
    
    public static void inputInto(Classs classs){
        Connection connection = DBConnection.openConnection();
        if (connection != null) {
            PreparedStatement preparedStatement = null;
            try {
                String sql = "insert into classs( idClass, nameClass) values( ?, ?)";
            
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, classs.getId());
                preparedStatement.setString(2, classs.getName());
                preparedStatement.execute();
            } catch (SQLException e) {
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
}
