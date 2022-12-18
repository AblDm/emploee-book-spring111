package com.skypro.employee.repositories;

import com.skypro.employee.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class EmployeeRepository {
    private static int lostId;

    public ArrayList<Employee> employeeArrayList;

    public EmployeeRepository(ArrayList<Employee> employees) {
        this.employeeArrayList = employees;
    }

    public ArrayList<Employee> getEmployeeArrayList() {
        return employeeArrayList;
    }

    public void addEmployee (Employee employee){
       this.employeeArrayList.add (employee);

    }

    public static int getLostId() {
        return lostId;
    }
}
