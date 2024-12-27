package com.csi.dao;

import com.csi.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;

@Component
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    public void signup(Employee employee) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
    }

    @Override
    public void saveBulkfData(List<Employee> employeeList) {
        Session session = factory.openSession();

        for (Employee employee : employeeList) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }

    }

    @Override
    public boolean signIn(String empEmailId, String empPassword) {
        boolean flag = false;
        for (Employee employee : findAll()) {
            if (employee.getEmpEmailId().equals(empEmailId) && employee.getEmpPassword().equals(empPassword)) {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public Employee findById(int empId) {
        Session session = factory.openSession();
        return (Employee) session.get(Employee.class, empId);
    }

    @Override
    public List<Employee> findAll() {
        Session session = factory.openSession();
        List<Employee> employeeList = session.createQuery("from Employee").list();
        return employeeList;
    }

    @Override
    public Employee findByContactNumber(long empContactNumber) {
        return findAll().stream().filter(emp -> emp.getEmpContactNumber() == empContactNumber).toList().get(0);
    }

    @Override
    public List<Employee> findByEmpName(String empName) {
        return findAll().stream().filter(emp -> emp.getEmpName().equals(empName)).toList();
    }

    @Override
    public List<Employee> findByDOB(String empDOB) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return findAll().stream().filter(emp -> simpleDateFormat.format(emp.getEmpDOB()).equals(empDOB)).toList();
    }

    @Override
    public List<Employee> findByAnyInput(String input) {

        return findAll().stream().filter(emp -> emp.getEmpName().equals(input)
                || String.valueOf(emp.getEmpId()).equals(input)
                || emp.getEmpPANCardNumber().equals(input)
                || String.valueOf(emp.getEmpContactNumber()).equals(input)
                || emp.getEmpEmailId().equals(input)
                || simpleDateFormat.format(emp.getEmpDOB()).equals(input)).toList();
    }

    @Override
    public List<Employee> sortById() {
        return findAll().stream().sorted(Comparator.comparingInt(Employee::getEmpId)).toList();
    }

    @Override
    public List<Employee> sortByName() {
        return findAll().stream().sorted(Comparator.comparing(Employee::getEmpName)).toList();
    }

    @Override
    public List<Employee> sortBySalary() {
        return findAll().stream().sorted(Comparator.comparingDouble(Employee::getEmpSalary)).toList();
    }

    @Override
    public List<Employee> sortByDOB() {
        return findAll().stream().sorted(Comparator.comparing(Employee::getEmpDOB)).toList();
    }

    @Override
    public boolean checkLoanEligibility(int empId) {
        return findAll().stream()
                .anyMatch(emp -> emp.getEmpId() == empId && emp.getEmpSalary() >= 50000.00);
    }


    @Override
    public List<Employee> filterDataBySalary(double empSalary) {
        return findAll().stream().filter(emp -> emp.getEmpSalary() >= empSalary).toList();
    }

    @Override
    public void updateData(int empId, Employee employee) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Employee employee1 = findById(empId);
        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpContactNumber(employee.getEmpContactNumber());
        employee1.setEmpPassword(employee.getEmpPassword());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpEmailId(employee.getEmpEmailId());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpGender(employee.getEmpGender());
        employee1.setEmpUID(employee.getEmpUID());
        employee1.setEmpPANCardNumber(employee.getEmpPANCardNumber());

        session.save(employee1);
        transaction.commit();

    }

    @Override
    public void partialUpdate(int empId, String empAddress, long empContactNumber) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee1 = findById(empId);
        employee1.setEmpAddress(empAddress);
        employee1.setEmpContactNumber(empContactNumber);
        session.update(employee1);
        transaction.commit();

    }

    @Override
    public void deleteById(int empId) {

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee1 = findById(empId);
        session.delete(employee1);
        transaction.commit();
    }

    @Override
    public void deleteAll() {

        Session session = factory.openSession();

        for (Employee employee : findAll()) {

            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }
}
