package com.skypro.employee.repositories;

import com.skypro.employee.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    private final List<Employee> employeeList = new ArrayList<> ();

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void addEmployee(Employee newEmployee) {
        employeeList.add (newEmployee);
    }


}
