package com.longhoang.springallofmodule2;

import com.longhoang.springallofmodule2.services.CustomerService;
import com.longhoang.springallofmodule2.services.impl.CustomerServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAllOfModule2Application {
    @Bean
    public CustomerService customerService() {
        return new CustomerServiceImpl();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringAllOfModule2Application.class, args);
    }

}
