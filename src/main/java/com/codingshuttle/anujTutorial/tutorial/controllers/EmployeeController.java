package com.codingshuttle.anujTutorial.tutorial.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.codingshuttle.anujTutorial.tutorial.dto.EmployeeDTO;

import jakarta.websocket.server.PathParam;

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

    // url : http://localhost:8080/employees
    @GetMapping(path = "/employees")
    public EmployeeDTO getEmployee() {
        return new EmployeeDTO(12, "Anuj", LocalDate.of(2024, 8, 28), true);
    }    

    // url : http://localhost:8080/employees/90000    -    Path variables
    @GetMapping(path = "/employees/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable("id") long id) {
        return new EmployeeDTO(id, "Anuj", LocalDate.of(2024, 8, 28), true);
    }
    
    // url : http://localhost:8080/sortemployees?sortBy=age         -    Path Params
    @GetMapping(path = "/sortemployees")
    public String getEmployeePathParam(@PathParam("sortBy") String sortBy,
                                        @PathParam("limit") Integer limit) {
        if(sortBy == null ){
            return "No sorting order mentioned";       //  will print No sorting order mentioned
        }else if (limit == null) {
            return "No limit mentioned";       //  will print No limit mentioned
        }
        else {
            return "Sort the given field by " + sortBy + " limit " + limit;       //  will print Sort the given field by (age/whatever is passed as the path param)
        }
    }


}
