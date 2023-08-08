package Model;

import lombok.Data;

@Data
public class Image {
    protected int id;
    protected String imagePath;

    public Image(int id, String imagePath) {
        this.id = id;
        this.imagePath = imagePath;
    }

    public Image() {
    }
}
