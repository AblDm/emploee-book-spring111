package com.skypro.employee.repositories;

import com.skypro.employee.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class EmployeeRepository {
    private static int lostId;

    private final List <Employee> employees;

    public EmployeeRepository(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee (Employee employee){
        employees.add (employee);
        ++lostId;
    }

    public static int getLostId() {
        return lostId;
    }
}
