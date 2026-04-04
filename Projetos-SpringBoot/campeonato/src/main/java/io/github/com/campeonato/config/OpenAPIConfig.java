package io.github.com.campeonato.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI campeonatoOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Campeonato")
                        .description("Campeonato API description")
                        .version("v0.0.1")
                        .license(new License()
                                .name("meu github")
                                .url("https://github.com/Marrafon91/Modelagem-UML/tree/main/Projetos-SpringBoot/campeonato")));
    }
}
