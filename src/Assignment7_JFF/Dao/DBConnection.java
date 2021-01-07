
package Assignment7_JFF.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;

    public static Connection openConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=ass7";
            String username = "sa";
            String password = "157748";
            connection =
                    DriverManager.getConnection(url, username, password);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
        }
        return null;
    }
    public  static  void closeConnection(){
        try {
            connection.close();
        } catch (SQLException throwables) {
        }
    }
}
