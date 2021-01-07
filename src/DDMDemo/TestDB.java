package DDMDemo;

import java.sql.*;

public class TestDB {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QLSinhVien";
            String username = "sa";
            String password = "157748";
            connection =
                    DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
            ResultSet resultSet =
                    statement.executeQuery("select * from SinhVien");

            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String tel = resultSet.getString("tel");

                System.out.printf("%d %s %s %s, %n", id, name, address, tel);
            }

            String newName = "New";
            String newAddress = "New";
            String newTel = "New";

//            String insertSQL = "insert into SinhVien(name, address, tel) " +
//                    "values ('" + newName + "','" + newAddress + "','" + newTel +  "')";
//            statement.execute(insertSQL);

            String insertSQL =
                    "insert into SinhVien(name, address, tel)  values (?, ?, ?)";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, newAddress);
            preparedStatement.setString(3, newTel);
            preparedStatement.executeUpdate();

            String updateSQL = "update SinhVien set name =  ?";
            preparedStatement =
                    connection.prepareStatement(updateSQL);
            preparedStatement.setString(1, "Bui Oanh");
            //preparedStatement.setInt(2, 1);


            preparedStatement.executeUpdate();

            String deleteSQL = "delete from SinhVien where name like ?";
            preparedStatement =
                    connection.prepareStatement(deleteSQL);
            //preparedStatement.setInt(1, 1);
            //preparedStatement.setInt(2, 3);
            preparedStatement.setString(1, "%Oanh%");
            preparedStatement.executeUpdate();

            DatabaseMetaData dm = connection.getMetaData();
            dm.getDriverName();

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
