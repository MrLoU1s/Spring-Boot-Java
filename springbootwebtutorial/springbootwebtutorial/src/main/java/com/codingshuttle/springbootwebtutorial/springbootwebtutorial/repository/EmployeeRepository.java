package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.repository;
//Deals with data logic enabling with operations on the Entity to database.


import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//no need to write data to manipulate data. i.e defining method to delete data, find by Id
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

    //here we'll connect controller to repository


}
