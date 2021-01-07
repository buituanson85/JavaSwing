/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_7.DAO;

import Assignment_7.Controller.DataMrg;
import Assignment_7.Model.Mark;
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
    public static List<Mark> findAll(){
        Connection connection = DBConnection.openConnection();
        List<Mark> markList = DataMrg.getInstance().getMarkList();

        if (connection != null) {
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet =
                        statement.executeQuery("select student.idStudent, classs.nameClass, student.nameStudent, mark.pga, subject.nameSub, semester.nameSem ,semester.dateSem\n" +
"	from student inner join classs on student.idClass = classs.idClass\n" +
"				inner join mark on mark.idStudent = student.idStudent\n" +
"				inner join subject on subject.idSub = mark.idSub\n" +
"				inner join semester on semester.idSem = mark.idSem");

                while (resultSet.next()) {                
                    Mark mark = new Mark(
                            resultSet.getString("idStudent"),
                            resultSet.getString("nameClass"),
                            resultSet.getString("nameStudent"),
                            resultSet.getFloat("pga"),
                            resultSet.getString("nameSub"),
                            resultSet.getString("nameSem"),
                            resultSet.getString("dateSem")
                    );
                    markList.add(mark);
                    mark.display();
                }
            } catch(SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        DBConnection.closeConnection();
        return markList;
    }
    
    public static void inputInto(String idStudent, String idSem,String idSub, float pga){
        Connection connection = DBConnection.openConnection();
        if (connection != null) {
            PreparedStatement preparedStatement = null;
            try {
                String sql = "insert into mark( idStudent, idSub, idSem, pga) values( ?, ?, ?, ?)";
            
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, idStudent);
                preparedStatement.setString(2, idSub);
                preparedStatement.setString(3, idSem);
                preparedStatement.setFloat(4, pga);
                preparedStatement.execute();
            } catch (Exception e) {
            }finally{
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MarkDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
