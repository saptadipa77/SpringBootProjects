package com.gevernova.SpringBootProjects.EmployeePayrollApp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

import java.util.List;

@Data
@Entity
@Table(name = "employee_payroll")

public class EmployeePayrollData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String gender;
    private long salary;
    private LocalDate startDate;
    private String note;
    private String profilePic;

    @ElementCollection
    @CollectionTable(
            name = "employee_department",
            joinColumns = @JoinColumn(name = "emp_id")
    )
    private List<String> department;
}
