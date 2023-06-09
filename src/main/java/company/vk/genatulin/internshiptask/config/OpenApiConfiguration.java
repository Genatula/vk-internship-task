package company.vk.genatulin.internshiptask.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Event API")
                        .version("1.0.0")
                        .contact(new Contact()
                                .email("ilnastheclown@gmail.com")
                                .name("Ilnas")));
    }
}
