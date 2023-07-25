package Model;

import lombok.Data;

@Data
public class Image {
    protected String id;
    protected String imagePath;

    public Image(String id, String imagePath) {
        this.id = id;
        this.imagePath = imagePath;
    }

    public Image() {
    }
}
