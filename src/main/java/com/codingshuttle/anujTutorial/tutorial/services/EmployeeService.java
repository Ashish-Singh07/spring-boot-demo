package com.codingshuttle.anujTutorial.tutorial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingshuttle.anujTutorial.tutorial.dto.EmployeeDTO;
import com.codingshuttle.anujTutorial.tutorial.entities.EmployeeEntity;
import com.codingshuttle.anujTutorial.tutorial.repositories.EmployeeRepository;

@Service
public class EmployeeService {

    // @Autowired - since we have created the constructor of the final object employeeRepository, we don't need autowired to get this into a Bean
    final EmployeeRepository employeeRepository;

    // This way of creating constructor of repository is called Constructor Injection. 
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDTO getEmployeeById(long id){
        EmployeeEntity employeeEntity = employeeRepository.getById(id);
        return new EmployeeDTO(employeeEntity.getId(), employeeEntity.getName(), employeeEntity.getDateOfJoining(), employeeEntity.isActive());
    }
}
