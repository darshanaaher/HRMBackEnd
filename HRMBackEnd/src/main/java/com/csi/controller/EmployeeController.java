package com.csi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.csi.model.Employee;
import com.csi.service.EmployeeService;


import java.util.List;

@Slf4j
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeServiceImpl;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody Employee employee) {
        //log.info("######TRYING TO SAVE DATA FOR EMPLOYEE :" + employee.getEmpName());
        employeeServiceImpl.signup(employee);
        return ResponseEntity.ok("SignUp Done Successfully");
    }

    @PostMapping("/savealldata")
    public ResponseEntity<String> saveBulkOfData(@RequestBody List<Employee> employeeList) {
        employeeServiceImpl.saveBulkfData(employeeList);
        return ResponseEntity.ok("All Data Saved Successfully");
    }

    @GetMapping("/findbyid/{empId}")
    public HttpEntity<Employee> findById(@PathVariable int empId) {
        return ResponseEntity.ok(employeeServiceImpl.findById(empId));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok(employeeServiceImpl.findAll());
    }

    @GetMapping("/findbyname/{empName}")

    public ResponseEntity<List<Employee>> findByName(@PathVariable String empName) {
        return ResponseEntity.ok(employeeServiceImpl.findByEmpName(empName));
    }

    @GetMapping("/findbycontactnumber/{empContactNumber}")
    public ResponseEntity<Employee> findByContactNumber(@PathVariable long empContactNumber) {
        return ResponseEntity.ok(employeeServiceImpl.findByContactNumber(empContactNumber));
    }

    @GetMapping("/findbydob/{empDOB}")
    public ResponseEntity<List<Employee>> findByDOB(@PathVariable String empDOB) {
        return ResponseEntity.ok(employeeServiceImpl.findByDOB(empDOB));
    }

    @GetMapping("/findbyanyinput/{input}")
    public ResponseEntity<List<Employee>> findByAnyInput(@PathVariable String input) {
        return ResponseEntity.ok(employeeServiceImpl.findByAnyInput(input));
    }

    @GetMapping("/sortbyid")
    public ResponseEntity<List<Employee>> sortById() {
        return ResponseEntity.ok(employeeServiceImpl.sortById());
    }

    @GetMapping("/sortbyname")
    public ResponseEntity<List<Employee>> sortByName() {
        return ResponseEntity.ok(employeeServiceImpl.sortById());
    }

    @GetMapping("/sortbysalary")
    public ResponseEntity<List<Employee>> sortBySalary() {
        return ResponseEntity.ok(employeeServiceImpl.sortById());
    }

    @GetMapping("/sortbydob")
    public ResponseEntity<List<Employee>> sortByDOB() {
        return ResponseEntity.ok(employeeServiceImpl.sortById());
    }

    @GetMapping("/checkingloaneligibility/{empId}")
    public ResponseEntity<String> checkLoanEligibility(@PathVariable int empId) {
        String msg = "";

        if (employeeServiceImpl.checkLoanEligibility(empId)) {

            msg = "Eligible for Loan";
        } else {
            msg = "Not Eligible for Loan";
        }
        return ResponseEntity.ok(msg);
    }

    @GetMapping("/filterdatabysalary/{empSalary}")
    public ResponseEntity<List<Employee>> filterDataBySalary (@PathVariable double empSalary){
        return ResponseEntity.ok(employeeServiceImpl.filterDataBySalary(empSalary));
    }

    @PutMapping("/updatedata/{empId}")
    public ResponseEntity<String> updateData(@PathVariable int empId, @RequestBody Employee employee){
    	employeeServiceImpl.updateData(empId, employee);
        return ResponseEntity.ok("Data Updated Successfully");
    }

    @PatchMapping("/updateaddressandcontactnumber/{empId}/{empAddress}/{empContactNumber}")
    public ResponseEntity<String> partialUpdate(@PathVariable int empId, @PathVariable String empAddress, @PathVariable long empContactNumber){
        employeeServiceImpl.partialUpdate(empId,empAddress,empContactNumber);
        return ResponseEntity.ok("Partial updation done successfully");
    }

    @DeleteMapping("/deletebyid/{empId}")
    public ResponseEntity<String> deleteById(@PathVariable int empId){
        employeeServiceImpl.deleteById(empId);
        return ResponseEntity.ok("Data deleted successfully");
    }

    /*@DeleteMapping("/deletealldata")
    public ResponseEntity<String> deleteAllData(){
        employeeServiceImpl.deleteAll();
        return ResponseEntity.ok("All data deleted successfully");
    }*/
}

