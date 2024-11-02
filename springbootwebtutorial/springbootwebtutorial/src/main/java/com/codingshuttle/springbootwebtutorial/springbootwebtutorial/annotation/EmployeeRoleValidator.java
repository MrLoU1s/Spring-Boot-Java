package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

//this impliments constraint validator and string fields
public class EmployeeRoleValidator implements ConstraintValidator<EmployeeRoleValidation,String> {
    @Override
    public boolean isValid(String inputRole, ConstraintValidatorContext constraintValidatorContext) {
        if(inputRole == null) return false;
        //returns boolean value ensuring string is passed or not.
        List<String> roles = List.of("USER","ADMIN");
        return roles.contains(inputRole);


    }
}
