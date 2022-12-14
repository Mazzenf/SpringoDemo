package com.springboot.demo.Controllers;


import com.springboot.demo.Entities.Department;
import com.springboot.demo.Error.DepartmentNotFoundException;
import com.springboot.demo.Services.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController
{


    @Autowired
    private DepartmentService departmentService;
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid  @RequestBody Department department) //@RequestBody means data we are getting in the request body (JSON) AND convert that json data to m department object
    {
        LOGGER.info("inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }



    @GetMapping("/departments")
    public List<Department> fetchDeprtmentList()
    {
        LOGGER.info("inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentID) throws DepartmentNotFoundException
    {
        return departmentService.fetchDepartmentById(departmentID);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentID)
    {
        departmentService.deleteDepartmentById(departmentID);

        return "Department deleted successfully.";

    }

    @PutMapping("/departments/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentID, @RequestBody Department department)
    {
        return departmentService.updateDepartmentById(departmentID,department);
    }


    @GetMapping("departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName)
    {
        return departmentService.fetchDepartmentByName(departmentName);
    }

}
