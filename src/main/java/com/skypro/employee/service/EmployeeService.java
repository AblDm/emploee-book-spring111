package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;


@Service
public class EmployeeService {
    private final Map <Integer, Employee> employees = new HashMap<>();

    public Collection <Employee> getAllEmployees(){
        return this.employees.values();
    }

    public Employee addEmployee (EmployeeRequest employeeRequest){
        if (employeeRequest.getLastName () == null || employeeRequest.getFirstName () == null){
            throw new IllegalArgumentException ("Employee name could be fill");
        }
        Employee employee = new Employee (employeeRequest.getFirstName (),
                employeeRequest.getLastName (),
                employeeRequest.getDepartment (),
                employeeRequest.getSalary ());

        this.employees.put (employee.getId (), employee);
        return employee;
    }

    public int getSallarySum () {
        return employees.values ().stream ()
                .mapToInt (Employee::getSalary)
                .sum ();
    }

    @GetMapping("/employee/salary/min")
    public Object getMinimalSalary () {
        Employee result = employees.get (0);
        int maxSallary = Integer.MIN_VALUE;
        for (int i = 0; i < employees.size (); i++) {
            if (employees.get (i).getSalary () > maxSallary) {
                maxSallary = employees.get (i).getSalary ();
                result = employees.get (i);
            }
        }
        return result;
    }

    public Object getMaximalSalary (){
        Employee result = employees.get (0);
        int minSallary = Integer.MAX_VALUE;
        for (int i = 0; i < employees.size () - 1; i++) {
            if (employees.get (i).getSalary () < minSallary) {
                minSallary = employees.get (i).getSalary ();
                result = employees.get (i);
            }
        }
        return result;
    }



    public Object getHighSalary () {
        int sum1 = 0;
        for (int i = 0; i < employees.size (); i++) {
            sum1 = sum1 + employees.get (i).getSalary ();
        }
        int overageSalary = (sum1 / employees.size ());

        List<Employee> result = new LinkedList<> ();
        for (int i = 0; i < employees.size (); i++) {
            {
                if (employees.get (i).getSalary () > overageSalary) {
                    System.out.println (employees.get (i));
                    result.add (employees.get (i));

                }
            }
        }return result;
    }
}
