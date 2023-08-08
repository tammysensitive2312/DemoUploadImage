package Dal;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseManager {
    private String URL = "jdbc:mysql://localhost:3306/springboot08";
    private String username = "root";
    private String password = "";
    protected Connection connection;

    public DatabaseManager() {
        this.connection();
    }

    public void connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL, username, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
