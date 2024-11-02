package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.annotation.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


// between presentation and service
public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "Name of employee cannot be blank.")
    @Size(min = 3, max = 10, message = "number of characters in name should be in the range 3-10")
    private String name;

    @NotBlank(message = "Email of employee cannot be blank.")
    @Email(message = "Email should be a valid email.")
    private String email;

    @NotNull(message = "Age of employee cannot be blank.")
    @Max(value = 80 , message = "Age cannot be greater than 80.")
    @Min(value = 18 , message = "Age cannot be less than 18." )
    private Integer age;


    //we are going to create our own annotation for checking the pattern
    //    @Pattern(regexp = "^(ADMIN|USER)$" ,message = "Role of employee can be USER or ADMIN only.")
    @NotBlank(message = "Role of employee cannot be blank.")
    @EmployeeRoleValidation
    private String role;//ADMIN / USER

    @NotNull(message = "Salary of Employee should be not null")
    @Positive(message = "Salary of employee should be positive.")
    @Digits(integer = 6, fraction = 2, message = "Salary can be in the form XXXXX.YY")
    @DecimalMax(value = "100000.99" )
    @DecimalMin(value = "100.50")
    private Double salary;

    //to ensure date of joining is in the past
    @PastOrPresent(message = "DateOfJoining field in Employee cannot be in the future")
    private  LocalDate dateOfJoining;

    @AssertTrue(message = "Employee should be active.")
    @JsonProperty("isActive")
    private Boolean isActive;

//    public EmployeeDTO(){
//
//    }
//    public EmployeeDTO(Long id, String name, String email, Integer age, LocalDate dateOfJoining, Boolean isActive) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.age = age;
//        this.dateOfJoining = dateOfJoining;
//        this.isActive = isActive;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public LocalDate getDateOfJoining() {
//        return dateOfJoining;
//    }
//
//    public void setDateOfJoining(LocalDate dateOfJoining) {
//        this.dateOfJoining = dateOfJoining;
//    }
//
//    public Boolean getActive() {
//        return isActive;
//    }
//
//    public void setActive(Boolean active) {
//        isActive = active;
//    }

    //So we have commented out the above code because we want to use lombok todefine the getters and setters instead of predefining them.


}
