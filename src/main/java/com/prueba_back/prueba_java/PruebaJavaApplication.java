package com.prueba_back.prueba_java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PruebaJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PruebaJavaApplication.class, args);
    }

}
