package com.codingshuttle.muiyurolouis.week1introduction.introductionToSpringBoot;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


//this keyword notifies the spring framework that this class Apple is now managed by the spring framework and all the objects of this class should be created by the framework
public class Apple {
    void eatApple() {
        System.out.println("I am eating the apple.");
    }
@PostConstruct
//don't worry about calling @ComponentScan and calling the method, IoC container does that on its own
    void callThisBeforeAppleIsUsed(){
        System.out.println("Create the apple before use.");
//will not be printed out because we haven't notified spring boot application or the component scanner that you should scan this method whenever spring application creates a bean of this apple class
        //(unless @PostConstruct is already called)
    }

    @PreDestroy
    void callThisBeforeDestroy(){
        System.out.println("Destroying the Apple bean");
    }

}
