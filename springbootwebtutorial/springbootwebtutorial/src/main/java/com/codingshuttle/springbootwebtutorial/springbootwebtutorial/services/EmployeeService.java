package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.services;
//deals with all service/business logic related to the Employee

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.repository.EmployeeRepository;
import org.aspectj.util.Reflection;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

//declares this as a service, enabling it to be injected in other codes
//getEmployeeID() - this used EmployeeRepository inside the EmployeeController which is a bad practise
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    //injecting ModelMapper here since employeeeRepository is dependent of it
    private final ModelMapper modelMapper;



    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }
    //Need something to convert Service to Entity and Entity to DTO, this can only be done in the Service
    //We also do not want to return an EmployeeEntity to the controller instead we want to return a EmployeeDTO
    //We also want to add status code over here

    public Optional<EmployeeDTO> getEmployeeById(Long id){
        //this returns EmployeeEntity
//      Optional< EmployeeEntity> employeeEntity= employeeRepository.findById(id);
       //Instead of doing this we can create a bean to prevent us keeping on creating more objects of Mapper in each method
//        ModelMapper mapper= new ModelMapper();
//        return employeeEntity.map(employeeEntity1->modelMapper.map(employeeEntity,EmployeeDTO.class);
       //one way of achieving the return EmployeeDTO is:
//        problem-will occur in ever stage so as to map each variable to the other, instead use a library called model mapper to achive this
//        return new EmployeeDTO(employeeEntity.getId(),employeeEntity.getName(),employeeEntity.getEmail());
return employeeRepository.findById(id).map(employeeEntity->modelMapper.map(employeeEntity,EmployeeDTO.class));


//transforming data entry to DTO here

}

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        //convert Entities to DTO using stream library
        return employeeEntities
                .stream()
                //converts each entity to the modelmapper
                .map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class))
                .collect(Collectors.toList());

    }

    //make it return DTO instead of Entity
    public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee) {
        //custom login can be added here- check if user us admin
        //log something


        //error occurs here because trying to save a DTO inside a Repository therefore Mapping required
        //convert DTO to entity, this method only accepts Entity
        EmployeeEntity toSaveEntity = modelMapper.map(inputEmployee, EmployeeEntity.class);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(toSaveEntity);
        //to return back DTO use modelmapper again
        return modelMapper.map(savedEmployeeEntity,EmployeeDTO.class);
    }

    //what if employee being searched for is not present?
    //Do we through an exception, create a new employee with the data.
    public EmployeeDTO updateEmployeeById(Long employeeId, EmployeeDTO employeeDTO) {
        //we are going to create a new employee with the data and if the employee is present we are going to update the details.
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO,EmployeeEntity.class);
         employeeEntity.setId(employeeId);
        EmployeeEntity saveEmployeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(saveEmployeeEntity,EmployeeDTO.class);

    }

    public boolean isExistsByEmployeeId(Long employeeId){
        return employeeRepository.existsById(employeeId);
    }

    public boolean deleteEmployeeById(Long employeeId) {
        //check if user present or not.
        boolean exists = isExistsByEmployeeId(employeeId);
        if(!exists) return false;
        employeeRepository.deleteById(employeeId);
        return true;
    }

    public EmployeeDTO updatePartialEmployeeById(Long employeeId, Map<String, Object> updates) {
        boolean exists =isExistsByEmployeeId(employeeId);
        if(!exists) return null;
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();
        //reflection- directly go through any object. Inversely direct field values.
        updates.forEach((field,value)->{
            Field fieldToBeUpdated = ReflectionUtils.findRequiredField(EmployeeEntity.class,field);
            //now making this field public since the attributes in the field are private
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated,employeeEntity,value);
        });
       //saving
        //have to return DTO thus call model mapper
        return modelMapper.map(employeeRepository.save(employeeEntity),EmployeeDTO.class);

    }
}
