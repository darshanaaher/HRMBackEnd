package com.csi.dao;

import com.csi.model.Employee;

import java.util.List;

public interface EmployeeDao {
    void signup(Employee employee);

    void saveBulkfData(List<Employee> employeeList);
    boolean signIn(String empEmailId, String empPassword);
    Employee findById(int empId);
    List<Employee> findAll();
    Employee findByContactNumber(long empContactNumber);
    List<Employee> findByEmpName(String empName);
    List<Employee> findByDOB(String empDOB);
    List<Employee> findByAnyInput(String input);
    List<Employee> sortById();
    List<Employee> sortByName();
    List<Employee> sortBySalary();
    List<Employee> sortByDOB();
    boolean checkLoanEligibility(int empId);
    List<Employee> filterDataBySalary(double empSalary);
    void updateData(int empId, Employee employee);
    void partialUpdate(int empId, String empAddress, long empContactNumber);
    void deleteById(int empId);
    void deleteAll();

}
