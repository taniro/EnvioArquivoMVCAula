package tads.eaj.ufrn.envioarquivomvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class EnvioArquivoMvcApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(EnvioArquivoMvcApplication.class, args);
    }



    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Register resource handler for images
        registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/");
    }
}
