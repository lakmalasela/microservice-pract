package com.example.departmentservice.controller;


import com.example.departmentservice.client.EmployeeClient;
import com.example.departmentservice.model.Department;
import com.example.departmentservice.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {


    private static  final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentRepository daodepartment;

    @Autowired
    private EmployeeClient employeeClient;



    @PostMapping
    public Department add(@RequestBody Department department){
        LOGGER.info("Department add: {}", department);
//        LOGGER.info("Department add: {}", department);
        return daodepartment.addDepartment(department);
    }

    @GetMapping(value = "/list")
    public List<Department> departmentList(){
        LOGGER.info("Department Find");
        return daodepartment.findAll();
    }

    @GetMapping(value = "/{id}")
    public Department findById(@PathVariable Integer id){
        LOGGER.info("Departmnet={}",id);
        return daodepartment.findById(id);
    }


    @GetMapping(value = "/with-employees")
    public List<Department> findAllwithEmployees(){
        LOGGER.info("Department Find");
       List<Department> departments = daodepartment.findAll();
       departments.forEach(department -> department.setEmployees(employeeClient.findByIdDepartment(department.getId())));
       return departments;
    }
}
