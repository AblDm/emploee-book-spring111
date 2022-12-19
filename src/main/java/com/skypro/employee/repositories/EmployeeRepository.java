package com.skypro.employee.repositories;

import com.skypro.employee.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class EmployeeRepository {

    public final ArrayList<Employee> employeeList;

    public EmployeeRepository() {
        this.employeeList = new ArrayList<> ();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public void addEmployee(Employee newEmployee) {
        this.employeeList.add (newEmployee);
    }


}
