package com.gevernova.SpringBootProjects.EmployeePayrollApp.repository;

import com.gevernova.SpringBootProjects.EmployeePayrollApp.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeePayrollRepository
        extends JpaRepository<EmployeePayrollData, Long> {

    @Query(
            value =
                    "SELECT e.* FROM employee_payroll e " +
                            "JOIN employee_department d ON e.id = d.emp_id " +
                            "WHERE d.department = :department",
            nativeQuery = true
    )
    List<EmployeePayrollData> findEmployeesByDepartment(
            @Param("department") String department
    );
}
