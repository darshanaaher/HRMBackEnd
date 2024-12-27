package com.csi.service;

import com.csi.dao.EmployeeDao;
import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeDao employeeDaoImpl;


    @Override
    public void signup(Employee employee) {
        employeeDaoImpl.signup(employee);
    }

    @Override
    public void saveBulkfData(List<Employee> employeeList) {

        employeeDaoImpl.saveBulkfData(employeeList);
    }

    @Override
    public boolean signIn(String empEmailId, String empPassword) {

        return employeeDaoImpl.signIn(empEmailId, empPassword);
    }

    @Override
    public Employee findById(int empId) {
        return employeeDaoImpl.findById(empId);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDaoImpl.findAll();
    }

    @Override
    public Employee findByContactNumber(long empContactNumber) {
        return employeeDaoImpl.findByContactNumber(empContactNumber);
    }

    @Override
    public List<Employee> findByEmpName(String empName) {
        return employeeDaoImpl.findByEmpName(empName);
    }

    @Override
    public List<Employee> findByDOB(String empDOB) {
        return employeeDaoImpl.findByDOB(empDOB);
    }

    @Override
    public List<Employee> findByAnyInput(String input) {
        return employeeDaoImpl.findByAnyInput(input);
    }

    @Override
    public List<Employee> sortById() {
        return employeeDaoImpl.sortById();
    }

    @Override
    public List<Employee> sortByName() {
        return employeeDaoImpl.sortByName();
    }

    @Override
    public List<Employee> sortBySalary() {
        return employeeDaoImpl.sortBySalary();
    }

    @Override
    public List<Employee> sortByDOB() {
        return employeeDaoImpl.sortByDOB();
    }

    @Override
    public boolean checkLoanEligibility(int empId) {
        return employeeDaoImpl.checkLoanEligibility(empId);
    }


    @Override
    public List<Employee> filterDataBySalary(double empSalary) {
        return employeeDaoImpl.filterDataBySalary(empSalary);
    }

    @Override
    public void updateData(int empId, Employee employee) {

        employeeDaoImpl.updateData(empId, employee);
    }

    @Override
    public void partialUpdate(int empId, String empAddress, long empContactNumber) {

        employeeDaoImpl.partialUpdate(empId, empAddress, empContactNumber);
    }

    @Override
    public void deleteById(int empId) {

        employeeDaoImpl.deleteById(empId);
    }

    @Override
    public void deleteAll() {
        employeeDaoImpl.deleteAll();
    }
}
