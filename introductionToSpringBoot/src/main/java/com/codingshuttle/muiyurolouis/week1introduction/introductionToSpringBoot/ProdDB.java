package com.codingshuttle.muiyurolouis.week1introduction.introductionToSpringBoot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//we are marking it as a component for the sake of demonstrating how dependency injection works


@ConditionalOnProperty(name="deploy.env",havingValue ="production")
public class ProdDB implements DB {
    public String getData() {
        return "Production Data";
    }
}
