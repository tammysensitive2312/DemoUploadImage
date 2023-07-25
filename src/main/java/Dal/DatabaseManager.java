package Dal;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseManager {
    private String URL = "jdbc:mysql://localhost:3306/image_upload_db";
    private String username = "root";
    private String password = null;
    protected Connection connection;

    public DatabaseManager() {
        this.Connection();
    }

    public void Connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL, username, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
