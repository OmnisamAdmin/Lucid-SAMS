package za.co.sfy.lucid.sams.swagger.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "za.co.sfy.lucid.sams.rest")
public class SwaggerConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info().title("Lucid-SAMS Services")
                        .description("Documentation for all services developed for use in the Lucid-SAMS project.")
                        .version("1.0")
                );
    }
}