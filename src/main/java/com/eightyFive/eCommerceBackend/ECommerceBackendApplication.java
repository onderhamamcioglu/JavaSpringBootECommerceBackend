package com.eightyFive.eCommerceBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ECommerceBackendApplication {
    public static void main(String[] args) {SpringApplication.run(ECommerceBackendApplication.class, args);}
}
