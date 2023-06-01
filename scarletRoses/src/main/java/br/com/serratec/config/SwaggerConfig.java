package br.com.serratec.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
@SecurityScheme(
        name = "Bearer Auth",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
    )
public class SwaggerConfig {

    @Value("${api.swagger.dev-url}")
	private String devUrl;
	
	@Bean
	public OpenAPI myOpenAPI() {
		Server devServer = new Server();
		devServer.setUrl(devUrl);
		devServer.setDescription("Server Url - ambiente de desenvolvimento");
		
		Contact contact = new Contact();
		contact.setEmail("carlos.e.oliveira16@aluno.senai.br");
		contact.setName("API-GRP5");
		contact.setUrl("http://www.aula.com");
		
		License license = new License()
				.name("Apache License Version 2.0")
				.url("https://www.apache.org/license/LICENSE-2.0");
		
		Info info = new Info()
				.title("Documentação API - Aula")
				.version("1.0.0")
				.contact(contact)
				.termsOfService("https:/www.aula.com/terms")
				.license(license);
		
		return new OpenAPI().info(info).servers(List.of(devServer));	
	}
}