package com.springboot.demo.Services;

import com.springboot.demo.Entities.Department;
import com.springboot.demo.Error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService
{
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentID) throws DepartmentNotFoundException;


    public void deleteDepartmentById(Long departmentID);

    public Department updateDepartmentById(Long departmentID, Department department);

    public Department fetchDepartmentByName(String departmentName);
}
