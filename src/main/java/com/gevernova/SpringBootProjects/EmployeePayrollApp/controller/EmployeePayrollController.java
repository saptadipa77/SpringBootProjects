package com.gevernova.SpringBootProjects.EmployeePayrollApp.controller;


import com.gevernova.SpringBootProjects.EmployeePayrollApp.dto.EmployeePayrollDTO;
import com.gevernova.SpringBootProjects.EmployeePayrollApp.model.EmployeePayrollData;
import com.gevernova.SpringBootProjects.EmployeePayrollApp.service.IEmployeePayrollService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    private final IEmployeePayrollService service;

    public EmployeePayrollController(IEmployeePayrollService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public EmployeePayrollData create(@Valid @RequestBody EmployeePayrollDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/")
    public List<EmployeePayrollData> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public EmployeePayrollData getById(@PathVariable long id) {
        return service.getById(id);
    }

    @PutMapping("/update/{id}")
    public EmployeePayrollData update(
            @PathVariable long id,
            @Valid @RequestBody EmployeePayrollDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

    @GetMapping("/department/{dept}")
    public List<EmployeePayrollData> getByDept(@PathVariable String dept) {
        return service.getByDepartment(dept);
    }
}
