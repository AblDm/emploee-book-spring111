package com.skypro.employee.service.employee_service;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import com.skypro.employee.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;


@Service
public class EmployeeService {

    public final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Collection <Employee> getAllEmployees(){
        return this.employeeRepository.getEmployeeArrayList ();
    }

    public Employee addEmployee (EmployeeRequest employeeRequest){
        if (employeeRequest.getLastName () == null || employeeRequest.getFirstName () == null){
            throw new IllegalArgumentException ("Employee name could be fill");
        }
        Employee employee = new Employee (
                StringUtils.capitalize(employeeRequest.getFirstName ()),
                StringUtils.capitalize(employeeRequest.getLastName ()),
                employeeRequest.getDepartment (),
                employeeRequest.getSalary ());

        this.employeeRepository.addEmployee (employee);
        return employee;
    }

    public int getSallarySum () {
        return employeeRepository.getEmployeeArrayList ().stream ()
                .mapToInt (Employee::getSalary)
                .sum ();
    }

    public int getMinimalSalary () {
        int result = employeeRepository.getEmployeeArrayList ().get (0).getSalary ();
        int maxSallary = Integer.MIN_VALUE;

        for (int i = 0; i < employeeRepository.getEmployeeArrayList ().size () - 1; i++) {
            if (employeeRepository.getEmployeeArrayList ().get (i).getSalary () > maxSallary) {
                maxSallary = employeeRepository.getEmployeeArrayList ().get (i).getSalary ();
                result = employeeRepository.getEmployeeArrayList ().get (i).getSalary ();
            }
        }
        return result;
    }

    public int getMaximalSalary() {

        int result = employeeRepository.getEmployeeArrayList ().get (0).getSalary ();
        int minSallary = Integer.MAX_VALUE;

        for (int i = 0; i < employeeRepository.getEmployeeArrayList ().size () - 1; i++) {
            if (employeeRepository.getEmployeeArrayList ().get (i).getSalary () < minSallary) {
                minSallary = employeeRepository.getEmployeeArrayList ().get (i).getSalary ();
                result = employeeRepository.getEmployeeArrayList ().get (i).getSalary ();
            }
        }
        return result;
    }



    public List<Employee> getHighSalary () {
        int sum1 = 0;
        for (int i = 0; i < employeeRepository.getEmployeeArrayList ().size (); i++) {
            sum1 = sum1 + employeeRepository.getEmployeeArrayList ().get (i).getSalary ();
        }   int overageSalary = (sum1 / employeeRepository.getEmployeeArrayList ().size ());

        List<Employee> result = new LinkedList<> ();
        for (int i = 0; i < employeeRepository.getEmployeeArrayList ().size (); i++) {{
            if (employeeRepository.getEmployeeArrayList ().get (i).getSalary () > overageSalary)
            {System.out.println (employeeRepository.getEmployeeArrayList ().get (i));
                result.add (employeeRepository.getEmployeeArrayList ().get (i));
            }

        }
        } return result;
    }
}