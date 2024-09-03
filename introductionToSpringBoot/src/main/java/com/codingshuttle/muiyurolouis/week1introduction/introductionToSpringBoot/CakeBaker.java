package com.codingshuttle.muiyurolouis.week1introduction.introductionToSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CakeBaker {

    final private  Frosting frost;
    final private  Syrup syrup;


    public CakeBaker(Frosting frost, Syrup syrup) {
        this.frost = frost;
        this.syrup = syrup;
    }

    public String bakeCake() {
        return  "Frosting type :"+ frost.getFrostingType() +"       Syrup type :"+ syrup.getSyrupType() ;
    }
}