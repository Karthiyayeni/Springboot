package com.dailycodebuffer.springboot.tutuorial.service;

import com.dailycodebuffer.springboot.tutuorial.entity.Department;
import com.dailycodebuffer.springboot.tutuorial.error.DepartmentNotFoundException;
import com.dailycodebuffer.springboot.tutuorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl  implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
     Optional<Department> department = departmentRepository.findById(departmentId);
     if(!department.isPresent()){
         throw new DepartmentNotFoundException("Departemnt not available");
     }
     return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depart = departmentRepository.findById(departmentId).get();
       if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
           depart.setDepartmentName(department.getDepartmentName());
       }
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depart.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            depart.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(depart);

    }

    @Override
    public Department findByDepartmentName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

}
