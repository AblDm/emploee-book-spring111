package com.skypro.employee.service.employee_service;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import com.skypro.employee.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class EmployeeService {

    public EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List <Employee> getAllEmployees(){
        return employeeRepository.getEmployeeList ();
    }

    public Employee addEmployee(EmployeeRequest employeeRequest) {
        if (employeeRequest.getLastName () == null || employeeRequest.getFirstName () == null) {
            throw new IllegalArgumentException ("Employee name could be fill");
        }
        Employee employee = new Employee (
                StringUtils.capitalize (employeeRequest.getFirstName ()),
                StringUtils.capitalize (employeeRequest.getLastName ()),
                employeeRequest.getDepartment (),
                employeeRequest.getSalary ());
        this.employeeRepository.addEmployee (employee);
        return employee;
    }

    public int getSallarySum() {
        return employeeRepository.getEmployeeList ().stream ()
                .mapToInt (Employee::getSalary)
                .sum ();
    }

    public int getMinimalSalary() {
        return employeeRepository.getEmployeeList ().stream ()
                .mapToInt (Employee::getSalary)
                .min ().orElse (0);

    }

    public int getMaximalSalary() {

        return employeeRepository.getEmployeeList ().stream ()
                .mapToInt (Employee :: getSalary)
                .max ().orElse (0);
    }


    public List<Employee> getHighSalary() {
        List<Employee> employeeList = employeeRepository.getEmployeeList ();
        double overageSalary = employeeList.stream ().mapToInt (Employee::getSalary).average ().orElse (0);
        return employeeList.stream ()
                .filter (employee -> employee.getSalary () > overageSalary)
                .collect(Collectors.toList());
    }
}