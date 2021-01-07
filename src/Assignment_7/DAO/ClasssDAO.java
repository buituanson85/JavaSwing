/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_7.DAO;

import Assignment_7.Controller.DataMrg;
import Assignment_7.Model.Classs;
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
public class ClasssDAO {
    public static List<Classs> findAll(){
        Connection connection = DBConnection.openConnection();
        List<Classs> classList = DataMrg.getInstance().getClassList();
        int count= 0;
        if (connection != null) {
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet =
                        statement.executeQuery("select * from classs");

                while (resultSet.next()) {
                    String id = resultSet.getString("idClass");
                    String name = resultSet.getString("nameClass");

                    Classs classs = new Classs();
                    
                    classs.setId(id);
                    classs.setName(name);
                    classList.add(classs);

                    classs.display();
                }
            } catch(SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        DBConnection.closeConnection();
        return classList;
    }
    
    public static void inputInto(String idClass, String nameClass){
        Connection connection = DBConnection.openConnection();
        if (connection != null) {
            PreparedStatement preparedStatement = null;
            try {
                String sql = "insert into classs( idClass, nameClass) values( ?, ?)";
            
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, idClass);
                preparedStatement.setString(2, nameClass);
                preparedStatement.execute();
            } catch (Exception e) {
            }finally{
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClasssDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
