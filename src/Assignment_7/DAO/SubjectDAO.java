/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_7.DAO;

import Assignment_7.Controller.DataMrg;
import Assignment_7.Model.Subject;
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
public class SubjectDAO {
    public static List<Subject> findAll(){
        Connection connection = DBConnection.openConnection();
        List<Subject> subjectList = DataMrg.getInstance().getSubjectList();

        if (connection != null) {
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet =
                        statement.executeQuery("select * from subject");

                while (resultSet.next()) {
                    String id = resultSet.getString("idSub");
                    String name = resultSet.getString("nameSub");

                    Subject subject = new Subject();
                    subject.setId(id);
                    subject.setName(name);
                    subjectList.add(subject);

                    subject.display();
                }
            } catch(SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        DBConnection.closeConnection();
        return subjectList;
    }
    
    public static void inputInto(String idSub, String nameSub){
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
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
