package br.com.fiap.plantanalytics.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class DocumentationConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Plant Analytics API")
                        .description("Uma API para o sistema de verificação de doenças em plantas.")
                        .summary("A API da Plant Analytics serve como a base para um aplicativo móvel que permite aos usuários saberem se suas plantas estão com algum tipo de doença e como trata-la.")
                        .version("V1")
                        .contact(new Contact()
                                .name(  "RM 93032 - André Teixeira" +
                                        "RM 94764 - Erick Soares" +
                                        "RM 93535 - Erik Salafia")
                        )
                )
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer")
                                        .bearerFormat("JWT")));
    }

}
