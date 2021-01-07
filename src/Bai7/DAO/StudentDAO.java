/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai7.DAO;

import Bai7.Model.Student;
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
public class StudentDAO {
    public static List<ISchool> findAll(){
        Connection connection = DBConnection.openConnection();
        List<ISchool> iiopList = DataMrg.getInstance().getiSchoolList();
        if (connection != null) {
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet =
                statement.executeQuery("select * from view_student");
                System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s", "Id", "Name", "Age", "Date", "Gender", "Address", "Phone", "NameClass");
                System.out.println("");
                while (resultSet.next()) {
                    String id = resultSet.getString("idStudent");
                    String name = resultSet.getString("nameStudent");
                    int age = resultSet.getInt("ageStudent");
                    String date = resultSet.getString("dateStudent");
                    String gender = resultSet.getString("genderStudent");
                    String address = resultSet.getString("addressStudent");
                    String phone = resultSet.getString("phoneStudent");
                    String nameClass = resultSet.getString("nameClass");

                    Student student = new Student();
                    
                    student.setId(id);
                    student.setName(name);
                    student.setAge(age);
                    student.setDate(date);
                    student.getGenderString();
                    student.setAddress(address);
                    student.setPhone(phone);
                    student.setNameClass(nameClass);
                    DataMrg.getInstance().getiSchoolList().add(student);

                    System.out.printf("%-20s %-20s %-20d %-20s %-20s %-20s %-20s %-20s %-20s", id, name, age, date, gender, name, address, phone, nameClass);
                    System.out.println("");
                }
            } catch(SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        DBConnection.closeConnection();
        return DataMrg.getInstance().getiSchoolList();
    }
    public static void inputInto(Student student){
        Connection connection = DBConnection.openConnection();
        if (connection != null) {
            PreparedStatement preparedStatement = null;
            try {
                String sql = "EXEC insert_student_by_id idStudent idStudent = ?, nameStudent = ?, ageStudent = ?, dateStudent = ?, genderStudent = ?, "
                        + "addressStudent = ?, phoneStudent = ?, idClass = ?";
            
                preparedStatement.setString(1, student.getId());
                    preparedStatement.setString(2, student.getName());
                    preparedStatement.setString(3, String.valueOf(student.getAge()));
                    preparedStatement.setString(4, student.getDate());
                    preparedStatement.setString(5, student.getGenderString());
                    preparedStatement.setString(6, student.getAddress());
                    preparedStatement.setString(7, student.getPhone());
                    preparedStatement.setString(8, student.getIdClass());
                    preparedStatement.execute();;
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
    }
}
