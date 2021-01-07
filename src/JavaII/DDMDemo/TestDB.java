package JavaII.DDMDemo;

import java.sql.*;

public class TestDB {
    public static void main(String[] args) {
        Connection connection = null;

        try { //ker noi vs driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QLSinhVien";
            String username = "sa";
            String password = "157748";
            connection = DriverManager.getConnection(url, username, password); //khoi tao collection

            //tao statement

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Student2");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                System.out.printf("%d %s %s, %n", id, name, phone);
            }

            int newID = 0;
            String newName = "new";
            String newPhone = "new";

//                String insertSQL = "insert into Student2(id, name, phone)" + " values('"+ newID + "','" + newName + "','" + newPhone +"')";
//                statement.execute(insertSQL);

            String inserSQL = "insert into Student2(name, phone) values(?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(inserSQL);
            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, newPhone);
            preparedStatement.executeUpdate();

            //update

//            String updateName = "Thanh";
            String updateSQL = "update Student2 set name = ? where id = ?";
            preparedStatement = connection.prepareStatement(updateSQL);
            preparedStatement.setString(1, "B");
            preparedStatement.setInt(2, 2);
            preparedStatement.executeUpdate();

//            String deleteSQL = "delete from Student2 set name = ? where id = ?";
//            preparedStatement = connection.prepareStatement(deleteSQL);
//            preparedStatement.setString(1, "B");
//            preparedStatement.setInt(2, 2);
//            preparedStatement.executeUpdate();

            DatabaseMetaData dm = connection.getMetaData();//kieemr tra phien ban MSQL

            

            preparedStatement.close();
            statement.close();
            resultSet.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
