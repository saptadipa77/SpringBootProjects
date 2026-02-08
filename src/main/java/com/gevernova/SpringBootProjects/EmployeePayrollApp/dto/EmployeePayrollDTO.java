package com.gevernova.SpringBootProjects.EmployeePayrollApp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;


import java.time.LocalDate;
import java.util.List;

@Data
public class EmployeePayrollDTO {

    @Pattern(
            regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",
            message = "Employee name Invalid"
    )
    private String name;

    @Pattern(
            regexp = "male|female",
            message = "Gender must be male or female"
    )
    private String gender;

    @NotNull
    private List<String> department;

    @Min(value = 500, message = "Salary must be >= 500")
    private long salary;

    @NotNull
    @PastOrPresent
    @JsonFormat(pattern = "dd MMM yyyy")
    private LocalDate startDate;

    @NotBlank
    private String note;

    @NotBlank
    private String profilePic;
}
