package com.codingshuttle.anujTutorial.tutorial.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.codingshuttle.anujTutorial.tutorial.dto.EmployeeDTO;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/*
 * Operations:
 * GET /employees
 * POST /employees
 * DELETE /employees/{id}
 * 
 */


@RestController
public class EmployeeController {

    @GetMapping(path = "/employees")
    public EmployeeDTO getEmployee() {
        return new EmployeeDTO(12, "Anuj", LocalDate.of(2024, 8, 28), true);
    }    

    @GetMapping(path = "/employees/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable("id") long id) {
        return new EmployeeDTO(id, "Anuj", LocalDate.of(2024, 8, 28), true);
    }    
}
