package com.skypro.employee.service.employee_service;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import com.skypro.employee.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;


@Service
public class EmployeeService {

    public EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public ArrayList <Employee> getAllEmployees(){
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
        return employeeRepository.employeeList.stream ()
                .mapToInt (Employee::getSalary)
                .sum ();
    }

    public int getMinimalSalary() {
        return employeeRepository.employeeList.stream ()
                .mapToInt (Employee::getSalary)
                .min ().orElse (0);

    }

    public int getMaximalSalary() {

        return employeeRepository.employeeList.stream ()
                .mapToInt (Employee :: getSalary)
                .max ().orElse (0);
    }


    public List<Employee> getHighSalary() {
        int sum1 = 0;
        for (int i = 0; i < employeeRepository.employeeList.size (); i++) {
            sum1 = sum1 + employeeRepository.employeeList.get (i).getSalary ();
        }
        int overageSalary = (sum1 / employeeRepository.getEmployeeList ().size ());

        List<Employee> result = new LinkedList<> ();
        for (int i = 0; i < employeeRepository.employeeList.size (); i++) {
            {
                if (employeeRepository.employeeList.get (i).getSalary () > overageSalary) {

                    result.add (result.get (i));
                }

            }
        }
        return result;
    }
}