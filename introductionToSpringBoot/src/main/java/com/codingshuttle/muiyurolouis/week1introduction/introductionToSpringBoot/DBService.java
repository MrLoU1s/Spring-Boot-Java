package com.codingshuttle.muiyurolouis.week1introduction.introductionToSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// this class is responsible for dependency injection
@Service
public class DBService {


//(Field injection - using the @Autowired annotation)
    // creating instances for DevDB and ProdDB
   /* @Autowired*/
   final private  DB db;



   //(Constructor  Injection)
    public DBService(DB db){
        this.db=db;

    }

    String getData(){
        // we can get multiple types of data(development database or production database)
        return db.getData();

    }
}
