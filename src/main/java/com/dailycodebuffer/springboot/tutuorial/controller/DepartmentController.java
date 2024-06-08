package com.dailycodebuffer.springboot.tutuorial.controller;

import com.dailycodebuffer.springboot.tutuorial.entity.Department;
import com.dailycodebuffer.springboot.tutuorial.error.DepartmentNotFoundException;
import com.dailycodebuffer.springboot.tutuorial.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    private  final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private DepartmentService departmentService;
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        System.out.println(department.getDepartmentCode());
      return departmentService.saveDepartment(department);
    }

    @GetMapping("/departmentList")
    public List<Department> fetchDepartmentList(){
        LOGGER.info("Inside fetch departmentList");
        return departmentService.fetchDepartmentList();


    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id")Long departmentId) throws DepartmentNotFoundException {
    return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/deleteDepartments/{id}")
    public String deleteDepartmentById(@PathVariable("id")Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully";

    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department){
        return departmentService.updateDepartment(departmentId,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name")String departmentName){
        return departmentService.findByDepartmentName(departmentName);

    }

}
