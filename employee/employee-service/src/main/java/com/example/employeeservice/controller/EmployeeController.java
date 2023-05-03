package com.example.employeeservice.controller;


import com.example.employeeservice.model.Employee;
import com.example.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    private static  final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository daoemployee;


    @PostMapping
    public Employee add(@RequestBody Employee employee){
        LOGGER.info("Employee add: {}", employee);

        return daoemployee.addEmployee(employee);
    }



    @GetMapping(value = "/list")
    public List<Employee> departmentList(){
        LOGGER.info("Employee Find");
        return daoemployee.findAll();
    }


    @GetMapping(value = "/{id}")
    public Employee findById(@PathVariable Integer id){
        LOGGER.info("Employee={}",id);
        return daoemployee.findById(id);
    }


    @GetMapping(value = "/department/{departmentid}")
    public List<Employee> findByIdDepartment(@PathVariable Integer departmentid){
        LOGGER.info("Employee Find: Departmentid={}",departmentid);
        return daoemployee.findByIddepartment(departmentid);
    }


}
