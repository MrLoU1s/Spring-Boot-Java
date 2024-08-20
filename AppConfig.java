package com.codingshuttle.muiyurolouis.week1introduction.introductionToSpringBoot;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
// define different beans in  the class
public class AppConfig {

    @Bean
    //this is defining the scope
    @Scope("singleton")
    Apple getApple(){
        // using new keyword coz creation of object is being acted on by developer but dependency injection part is taken care by spring boot application.
        // no need for calling the getApple() method
        return new Apple();
    }
}
