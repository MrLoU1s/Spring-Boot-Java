package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.controllers;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//To make repository

// annotate as RestController insteasd of Controller , to prevent having to annotate each mapping, this means all methods will return JSON/XML directly to the response body.
//Controller should use the service and DTO and should not use the Entity
@RestController
@RequestMapping(path="/employees")
public class EmployeeController {

    // componentscan will tell servlet dispatcher that all mappings here  conform to the server
//    @GetMapping(path = "/getSecretMessage")
//    public String getMySuperSecretMessage(){
//        return "Secret Message : vdifn33";
//    }



//    remove this code since this is a bad practicee having this business logic inside the controller instead of the service
//    private final EmployeeRepository employeeRepository

    //Instead adding instance of EmployeeService

    private final EmployeeService employeeService;

    //adding constructor
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }







//    public EmployeeController(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }


    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId")  Long id){
//        return employeeRepository.findById(id).orElse(null);
        return employeeService.getEmployeeById(id);

    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false, name="inputAge") Integer age, @RequestParam(required = false) String sortBy ){

//        return employeeRepository.findAll();
        return employeeService.getAllEmployees();

    }
    //RequestBody used to pass complex and large data instead of passing data through parameters

    @PostMapping
    //use EmployeeDTO
    public EmployeeDTO  createEmployees(@RequestBody EmployeeDTO  inputEmployee){
//     return employeeRepository.save(inputEmployee);
        return employeeService.createNewEmployee(inputEmployee);


    }

    @PutMapping
    String updateEmployeeId(){
        return "hello from PUT";
    }

    @DeleteMapping
    String deleteEmployeeId(){
        return "bye from DELETE";
    }




    

}
