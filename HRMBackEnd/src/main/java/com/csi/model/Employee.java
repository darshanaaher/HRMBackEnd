package com.csi.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {

    @Id
    @GeneratedValue
    private int empId;
    private String empName;
    private String empAddress;
    @Column(unique = true)
    private long empContactNumber;
    private double empSalary;
    @Column(unique = true)
    private String empPANCardNumber;
    private long empUID;
    private String empGender;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date empDOB;
    @Column(unique = true)
    private String empEmailId;
    private String empPassword;
}
