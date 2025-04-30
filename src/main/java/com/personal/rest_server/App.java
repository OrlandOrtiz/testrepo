package com.personal.rest_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.personal")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
