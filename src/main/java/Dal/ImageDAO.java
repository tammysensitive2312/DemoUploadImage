package Dal;

import Model.Image;

import java.sql.SQLException;
import java.util.ArrayList;

public class ImageDAO extends DatabaseManager {
    public void insert(String path) {
        try {
            this.connection.createStatement().executeUpdate("INSERT INTO images (path) VALUES ('" + path + "')");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Image> getList() {
        ArrayList<Image> images = new ArrayList<>();

        try {
            String sql = "SELECT * FROM images";
            var statment = this.connection.createStatement();
            var resultSet = statment.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String filePath = resultSet.getString("path");
                Image image = new Image(id, filePath);
                images.add(image);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return images;
    }
}
