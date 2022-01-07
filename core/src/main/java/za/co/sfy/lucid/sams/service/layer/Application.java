package za.co.sfy.lucid.sams.service.layer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(scanBasePackages = {"za.co.sfy.lucid.sams.rest", "za.co.sfy.lucid.sams.swagger"})
@ComponentScan(basePackages = {"za.co.sfy.lucid.sams.rest", "za.co.sfy.lucid.sams.swagger"})
@EntityScan(basePackages = {"za.co.sfy.lucid.sams.rest", "za.co.sfy.lucid.sams.swagger"})
@PropertySource(value = "classpath:application.properties")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS");
            }
        };
    }
}
