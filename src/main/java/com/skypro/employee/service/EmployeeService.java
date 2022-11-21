package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Service
public class EmployeeService {
    private final Map <Integer, Employee> employees = new HashMap<>();

    public Collection <Employee> getAllEmployees(){
        return this.employees.values();
    }

}
