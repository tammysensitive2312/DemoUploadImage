import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class ConfigResource implements WebMvcConfigurer {
    @Value("C:\\Users\\ACER\\Documents\\Images\\")
    public String UPLOAD_FOLDER;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("upload/**")
                .addResourceLocations("file"+UPLOAD_FOLDER);
    }
}
