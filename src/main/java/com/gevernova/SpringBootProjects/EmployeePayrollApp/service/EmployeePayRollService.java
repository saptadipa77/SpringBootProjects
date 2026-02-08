package com.gevernova.SpringBootProjects.EmployeePayrollApp.service;
import com.gevernova.SpringBootProjects.EmployeePayrollApp.dto.EmployeePayrollDTO;
import com.gevernova.SpringBootProjects.EmployeePayrollApp.model.EmployeePayrollData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.gevernova.SpringBootProjects.EmployeePayrollApp.repository.EmployeePayrollRepository;

import java.util.List;

@Slf4j
@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    private final EmployeePayrollRepository repository;

    public EmployeePayrollService(EmployeePayrollRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeePayrollData create(EmployeePayrollDTO dto) {
        EmployeePayrollData emp = new EmployeePayrollData();
        mapDtoToEntity(dto, emp);
        return repository.save(emp);
    }

    @Override
    public List<EmployeePayrollData> getAll() {
        return repository.findAll();
    }

    @Override
    public EmployeePayrollData getById(long id) {
        return null;
    }

    @Override
    public EmployeePayrollData getById(long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new EmployeePayrollException("Employee not found"));
    }

    @Override
    public EmployeePayrollData update(long id, EmployeePayrollDTO dto) {
        EmployeePayrollData emp = getById(id);
        mapDtoToEntity(dto, emp);
        return repository.save(emp);
    }

    @Override
    public void delete(long id) {
        repository.delete(getById(id));
    }

    @Override
    public List<EmployeePayrollData> getByDepartment(String department) {
        return repository.findEmployeesByDepartment(department);
    }

    private void mapDtoToEntity(EmployeePayrollDTO dto, EmployeePayrollData emp) {

        emp.setName(dto.getName());
        emp.setGender(dto.getGender());
        emp.setDepartment(dto.getDepartment());
        emp.setSalary(dto.getSalary());
        emp.setStartDate(dto.getStartDate());
        emp.setNote(dto.getNote());
        emp.setProfilePic(dto.getProfilePic());
    }
}
