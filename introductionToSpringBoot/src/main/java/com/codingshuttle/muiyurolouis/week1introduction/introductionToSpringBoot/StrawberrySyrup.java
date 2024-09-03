package com.codingshuttle.muiyurolouis.week1introduction.introductionToSpringBoot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name="deploy.env",havingValue ="Strawberry")
public class StrawberrySyrup implements Syrup {
    public String getSyrupType(){
        return "Strawberry" ;
    }
}
