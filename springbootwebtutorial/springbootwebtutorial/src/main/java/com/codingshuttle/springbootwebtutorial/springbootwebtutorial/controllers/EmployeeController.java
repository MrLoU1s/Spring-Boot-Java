package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.controllers;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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

//help in adding status code
    @GetMapping(path = "/{employeeId}")
    public ResponseEntity <EmployeeDTO> getEmployeeById(@PathVariable(name = "employeeId")  Long id){
//        return employeeRepository.findById(id).orElse(null);
        Optional<EmployeeDTO> employeeDTO =  employeeService.getEmployeeById(id);
        //return message if employee not found
//        if(employeeDTO ==null) return ResponseEntity.notFound().build();
//        //return message if employee is found alongside with employeeDTO object wrapped in an ReponseEntity.
//        return ResponseEntity.ok(employeeDTO);
        return employeeDTO
                .map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
                .orElse(ResponseEntity.notFound().build());

    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(@RequestParam(required = false, name="inputAge") Integer age,
                                                             @RequestParam(required = false) String sortBy ){

//        return employeeRepository.findAll();
        return ResponseEntity.ok(employeeService.getAllEmployees());

    }
    //RequestBody used to pass complex and large data instead of passing data through parameters

    @PostMapping

    //use EmployeeDTO
    public ResponseEntity<EmployeeDTO> createEmployees(@RequestBody @Valid EmployeeDTO  inputEmployee){
//     return employeeRepository.save(inputEmployee);
        EmployeeDTO savedEmployee =  employeeService.createNewEmployee(inputEmployee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);



    }

    //use this to update the whole data
    @PutMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long  employeeId){
        // ResponseEntity.ok() this adds the HHTP response code
        return ResponseEntity.ok(  employeeService.updateEmployeeById(employeeId, employeeDTO));


    }

   @DeleteMapping(path = "/{employeeId}" )
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long employeeId){
// ResponseEntity.ok() this adds the HHTP response code
        boolean getDeleted = employeeService.deleteEmployeeById(employeeId);
        if(getDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();

   }


   @PatchMapping(path = "/{employeeId}")
   public ResponseEntity<EmployeeDTO> updatePartialEmployeeById(@RequestBody Map<String , Object> update,
                                         @PathVariable Long  employeeId){
        EmployeeDTO employeeDTO =  employeeService.updatePartialEmployeeById(employeeId, update);
        if(employeeDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);

   }




    

}
