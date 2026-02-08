package com.gevernova.SpringBootProjects.EmployeePayrollApp.service;

import com.gevernova.SpringBootProjects.EmployeePayrollApp.dto.EmployeePayrollDTO;
import com.gevernova.SpringBootProjects.EmployeePayrollApp.model.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {

    EmployeePayrollData create(EmployeePayrollDTO dto);
    List<EmployeePayrollData> getAll();
    EmployeePayrollData getById(long id);
    EmployeePayrollData update(long id, EmployeePayrollDTO dto);
    void delete(long id);
    List<EmployeePayrollData> getByDepartment(String department);
}
