package com.springboot.demo.Services;

import com.springboot.demo.Entities.Department;
import com.springboot.demo.Repositories.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class DepartmentServiceTest
{

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;
    @BeforeEach
    void setUp()
    {
        Department department = Department.builder().departmentName("IT")
                .departmentAddress("Bangalore")
                .departmentCode("IT-06")
                .departmentID(1L)
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
    }


    @DisplayName("Get Data Based On Department Name")
    @Test
    public void whenValidDepartmentNameThenDepartmentShouldFound()
    {
        String departmentName = "IT";
        Department found = departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());

    }


}