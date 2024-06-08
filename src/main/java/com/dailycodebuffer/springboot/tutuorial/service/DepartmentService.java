package com.dailycodebuffer.springboot.tutuorial.service;

import com.dailycodebuffer.springboot.tutuorial.entity.Department;
import com.dailycodebuffer.springboot.tutuorial.error.DepartmentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DepartmentService {
   public  Department saveDepartment(Department department);

   List<Department> fetchDepartmentList();

   Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

   void deleteDepartmentById(Long departmentId);

   Department updateDepartment(Long departmentId, Department department);

   Department findByDepartmentName(String departmentName);
}
