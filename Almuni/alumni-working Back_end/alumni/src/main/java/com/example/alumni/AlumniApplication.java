package com.example.alumni;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AlumniApplication {

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
    public static void main(String[] args) {
        SpringApplication.run(AlumniApplication.class, args);
    }

}
