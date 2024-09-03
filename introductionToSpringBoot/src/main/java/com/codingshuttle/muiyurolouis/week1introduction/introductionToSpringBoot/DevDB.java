/*
package com.codingshuttle.muiyurolouis.week1introduction.introductionToSpringBoot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
//marking it as primary in case of an error due to multiple beans
@ConditionalOnProperty(name="deploy.env",havingValue ="development")
// only be loaded when condition on the properties is development
public class DevDB implements DB{

    public String getData(){
        return "Development Data";
    }
}
*/
