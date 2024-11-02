package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;



import java.time.LocalDate;

//All these help adding getters and setters automatically, instead of us having to add them in the code.
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//this enables this to be identified as an entity
@Table(name = "employees")
public class EmployeeEntity {

//    why repeating code? This is for security purposes i.e. having sensitive info like employee password in EmployeeEntity, if you do not want it in EmployeeDTO
//    . Validation logic in EmployeeDTO.
//    Logic for defining table and how data is stored into table is stored in the EmployeeEntity



    //a primary key
     @Id
     //Auto-increment
  @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate dateOfJoining;
    //add here because this relation situation of objects occur here again.
    @JsonProperty("isActive")
    private Boolean isActive;
    private String role;
    private Double  salary;



}
