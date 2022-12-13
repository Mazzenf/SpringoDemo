package com.springboot.demo.Services;


import com.springboot.demo.Entities.Department;
import com.springboot.demo.Error.DepartmentNotFoundException;
import com.springboot.demo.Repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.metamodel.ListAttribute;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImp implements DepartmenService
{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department)
    {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList()
    {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentID) throws DepartmentNotFoundException
    {
        Optional<Department> department = departmentRepository.findById(departmentID);
        if (!department.isPresent())
        {
            throw new DepartmentNotFoundException("Department not available");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentID)
    {
        departmentRepository.deleteById(departmentID);
    }

    @Override
    public Department updateDepartmentById(Long departmentID, Department department)
    {
        Department depDB = departmentRepository.findById(departmentID).get();

        if (Objects.nonNull(department.getDepartmentName())&& !"".equalsIgnoreCase(department.getDepartmentName()))
        {
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department.getDepartmentCode())&& !"".equalsIgnoreCase(department.getDepartmentCode()))
        {
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        if (Objects.nonNull(department.getDepartmentAddress())&& !"".equalsIgnoreCase(department.getDepartmentAddress()))
        {
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(depDB);


    }

    @Override
    public Department fetchDepartmentByName(String departmentName)
    {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }


}
