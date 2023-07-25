package Controllers;
import Model.Image;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;

@Controller("UploadImageController")
public class uploadImageController {
    @Value("${UPLOAD_DIR}")
    public String uploadDir;
    @GetMapping("/upload-image")
    public String uploadFile(Model model) {
        model.addAttribute("image", new Image());
        return "upload-image";
    }

    @PostMapping("/upload-image-handler")
    public String uploadFileHandler(
            @ModelAttribute Image image,
            @RequestParam("img") MultipartFile file) {

        try {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            String newDir = month + " " + year;

            File folder = new File(uploadDir + newDir);
            if(!folder.exists() || folder.isFile()) {
                folder.mkdir();
            }

            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\ACER\\Documents\\Images\\" + file.getOriginalFilename());
            fileOutputStream.write(file.getBytes());


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "redirect:upload-image";
    }
}
