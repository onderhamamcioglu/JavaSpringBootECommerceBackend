package com.eightyFive.eCommerceBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.eightyFive.eCommerceBackend.repository")
@SpringBootApplication()
public class ECommerceBackendApplication {
    public static void main(String[] args) {SpringApplication.run(ECommerceBackendApplication.class, args);}
}
