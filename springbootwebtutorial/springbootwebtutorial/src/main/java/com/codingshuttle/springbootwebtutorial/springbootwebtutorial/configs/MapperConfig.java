package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//define as  a configuration to prevent occuerence of error while application is strating
@Configuration

//this bean of ModelMapper can now be returned in the methods present in the EmployeeService layer
public class MapperConfig {
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
