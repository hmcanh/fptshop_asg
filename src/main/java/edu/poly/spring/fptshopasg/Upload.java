package edu.poly.spring.fptshopasg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class Upload  implements WebMvcConfigurer {
    @Value("${UPLOAD_FOLDER}")
    public  String UPLOAD_FOLDER;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("images/**").addResourceLocations(UPLOAD_FOLDER);
    }
}
