package com.fecbo.companydeviceregister.application;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SecurityScheme(
        type = SecuritySchemeType.APIKEY,
        name = "apikey",
        paramName = "Authorization",
        in = SecuritySchemeIn.HEADER
)
@SecurityScheme(
        type = SecuritySchemeType.OPENIDCONNECT,
        name = "openid"
)
@OpenAPIDefinition(
        servers = {
                @Server(url = "http://localhost:8080", description = "local dev")},
        info = @Info(
                title = "Company Device Register API",
                version = "v1",
                description = "Company Device Register API for Graphical User Interface",
                contact = @Contact(
                        name = "Feczkó Botond", email = "feczko_botond@ppke.itk.hu")))
@SpringBootApplication
@ComponentScan(basePackages = {"com.fecbo.companydeviceregister"})
@EntityScan(basePackages = {"com.fecbo.companydeviceregister.client.entity"})
@EnableJpaRepositories(basePackages = {"com.fecbo.companydeviceregister.client.repository"})
public class CompanyDeviceRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompanyDeviceRegisterApplication.class, args);
    }

}
