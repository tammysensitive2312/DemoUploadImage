package Dal;

import Model.Image;

import java.sql.SQLException;
import java.util.ArrayList;

public class DalUser extends DatabaseManager {
    public ArrayList<Image> getList() {
        ArrayList<Image> images = new ArrayList<Image>();

        try {
            String sql = "SELECT * FROM images";
            var statment = this.connection.createStatement();
            var resultSet = statment.executeQuery(sql);
            while (resultSet.next()) {
                String id = resultSet.getString("ID");
                String filePath = resultSet.getString("file_path");
                Image image = new Image(id,filePath);
                images.add(image);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return images;
    }
}
