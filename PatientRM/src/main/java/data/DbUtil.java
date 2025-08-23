package data;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
    public static Connection getConnection() throws Exception {
        // mysql driver class
        Class.forName("com.mysql.cj.jdbc.Driver");
        // getConnection(jdbc:mysql://host:port/database,username,password)
        Connection connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/gnanamani","root","Razak@123");
        return connection;
    }
}
