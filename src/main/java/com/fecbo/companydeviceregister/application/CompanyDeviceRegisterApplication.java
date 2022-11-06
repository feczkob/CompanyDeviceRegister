package com.fecbo.companydeviceregister.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.fecbo.companydeviceregister"})
@EntityScan(basePackages = {"com.fecbo.companydeviceregister.client.entity"})
@EnableJpaRepositories(basePackages = {"com.fecbo.companydeviceregister.client.repository"})
public class CompanyDeviceRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompanyDeviceRegisterApplication.class, args);
    }

}
