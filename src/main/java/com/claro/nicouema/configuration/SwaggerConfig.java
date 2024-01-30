package com.claro.nicouema.configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import jakarta.servlet.ServletContext;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@Getter
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class SwaggerConfig {

    @Value("${api.info.title}")
    private String title;

    @Value("${api.info.nameContact}")
    private String nameContact;

    @Value("${api.info.mailContact}")
    private String emailContact;

    @Value("${api.info.description}")
    private String description;

    @Value("${api.info.version}")
    private String version;

    @Bean
    public OpenAPI openAPI(ServletContext servletContext) {
        Server server = new Server().url(servletContext.getContextPath());
        return new  OpenAPI().servers(List.of(server)).info(createOpenApiInfo());
    }

    public Info createOpenApiInfo(){
        Info info = new Info();
        info.setTitle(title);
        info.setContact(new Contact().name(nameContact).email(emailContact));
        info.setDescription(description);
        info.setVersion(version);

        return info;
    }
}
