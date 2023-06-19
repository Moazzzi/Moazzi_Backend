package moadda.moazzi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {

        Info info = new Info()
                .version("v1.0.0")
                .title("푸드트럭 축제 정보 API")
                .description("푸드트럭 축제 정보 API");

        return new OpenAPI().info(info);
    }
}
