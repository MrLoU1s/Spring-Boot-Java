package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
//defining targets to fields only
@Target({ElementType.FIELD, ElementType.PARAMETER})
//connectinng annotation with the constraint
@Constraint(validatedBy = {EmployeeRoleValidator.class})

//this defines the structure of the validation.
public @interface EmployeeRoleValidation {

    String message() default "Role of employee can be USER or ADMIN only.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
