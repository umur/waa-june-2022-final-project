package com.cs545waa.waaJune2022finalProject;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AlumniManagementPortalApplication {

    public static void main(String[] args) {
        //shgds
        SpringApplication.run(AlumniManagementPortalApplication.class, args);
        //System.out.println("GITHUB");

    }
    @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }

}
