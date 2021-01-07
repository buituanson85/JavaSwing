package Assignment5.Dao;

import Assignment5.Controller.DataMrg;
import Assignment5.Model.Employee;

import java.sql.*;
import java.util.List;

public class EmployeeDAO {

    public void create(String name, float salary, float insurance){
//        List<Employee> employeeList = DataMrg.getInstance().getEmployeeList();
        Connection connection = DBConection.openConnection();
        if (connection != null) {
            String sql =
                    "insert into Employee(name, salary, insurance)  values (?, ?, ?)";
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setString(1, name);
                preparedStatement.setFloat(2, salary);
                preparedStatement.setFloat(3, insurance);
                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        DBConection.closeConnection();
    }
    public List<Employee> findAll(){
        Connection connection = DBConection.openConnection();
//        List<Employee> employees = new ArrayList<>();
        List<Employee> employeeList = DataMrg.getInstance().getEmployeeList();

        if (connection != null) {
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet =
                        statement.executeQuery("select * from Employee");

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    float salary = resultSet.getFloat("salary");
                    float insurance = resultSet.getFloat("insurance");

                    Employee employee = new Employee();
                    employee.setId(id);
                    employee.setName(name);
                    employee.setSalary(salary);
                    employee.setInsurance(insurance);
                    employeeList.add(employee);

                    System.out.printf("%d %s %s %s, %n", id, name, salary, insurance);
                }
            } catch(SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        DBConection.closeConnection();
        return employeeList;
    }
}

