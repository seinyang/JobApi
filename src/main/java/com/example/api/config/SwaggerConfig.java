package com.example.api.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.Contact;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@OpenAPIDefinition(
        info = @Info(
                title = "Api 명세서",
                description = "API에 대한 자세한 설명을 기록한 문서입니다.",
                version = "v1",
                contact = @Contact(
                        name = "sein",
                        email = "did756984@example.com",
                        url = "https://www.example.com"
                )
        )
)
@Configuration

public class SwaggerConfig {

}