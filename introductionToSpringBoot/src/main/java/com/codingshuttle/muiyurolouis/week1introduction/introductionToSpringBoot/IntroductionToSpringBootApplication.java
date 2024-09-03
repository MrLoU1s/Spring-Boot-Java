package com.codingshuttle.muiyurolouis.week1introduction.introductionToSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntroductionToSpringBootApplication implements CommandLineRunner {

/*	@Autowired
			//notifies framework that the object should be injected where required
	Apple apple1 ;

	@Autowired
	Apple apple2;
	//dependency injected here*/
@Autowired
CakeBaker cakeBaker;

	//@Autowired
	//DBService dbService;

	public static void main(String[] args) {

		SpringApplication.run(IntroductionToSpringBootApplication.class, args);
		// this method called because of dependency injection

		//creating object for the Apple class

		// creating bean(we don't have to use "new" keyword)

// an error is brought about non-static object cannot be referenced from the static context

		//



	}

	// this will still result to error because we have not instantiated the object and not defined the apple as a bean so spring framework is not managing the object for me (NullPointerException error-Runtime error)
	@Override
	public void run(String... args) throws Exception {

		//
		//
		 System.out.println(cakeBaker.bakeCake());
		//System.out.println(dbService.getData());


		// code been commented for the sake of dependency injection presentation
		/*apple1.eatApple();

		apple2.eatApple();
		// bean  used here

		//checking whether there are different objects created through the use of @Scope("prototype")
		System.out.println(apple1.hashCode());
		System.out.println(apple2.hashCode());
*/
	}
}
