package com.fecbo.companydeviceregister.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.fecbo.companydeviceregister"})
@EntityScan(basePackages = {"com.fecbo.companydeviceregister.client.entity"})
public class CompanyDeviceRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompanyDeviceRegisterApplication.class, args);
    }

}
