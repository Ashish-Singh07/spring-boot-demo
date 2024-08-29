package com.codingshuttle.anujTutorial.tutorial.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingshuttle.anujTutorial.tutorial.dto.EmployeeDTO;
import com.codingshuttle.anujTutorial.tutorial.entities.EmployeeEntity;
import com.codingshuttle.anujTutorial.tutorial.repositories.EmployeeRepository;

@Service
public class EmployeeService {

    // @Autowired - since we have created the constructor of the final object employeeRepository, we don't need autowired to get this into a Bean
    final EmployeeRepository employeeRepository;

    final ModelMapper modelMapper;

   
    // This way of creating constructor of repository is called Constructor Injection. 
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = new ModelMapper();
    }

    public EmployeeDTO getEmployeeById(long id){
        EmployeeEntity employeeEntity = employeeRepository.getById(id);
        // return new EmployeeDTO(employeeEntity.getId(), employeeEntity.getName(), employeeEntity.getDateOfJoining(), employeeEntity.isActive());
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }
}

/*
 * In order to save time converting the EmployeeDTO to EmployeeEntity and vice versa, we can use a dependency called modelmapper.
 *  * ModelMapper is a library that helps us to convert one object to another. so we can use it in our service layer.
 * 
 * 
 */