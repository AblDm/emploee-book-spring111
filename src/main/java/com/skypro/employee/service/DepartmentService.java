package com.skypro.employee.service;

import com.skypro.employee.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface DepartmentService {
    public Set<Integer> getExistingDepartments();

    public Map<Integer, List<Employee>> getEmployeeByDepartment ();

    public Collection<Employee> getEmployeeFromDepartment (int department);

    public int getSalarySumOfDepartment (int department);

    public int getMinimalSalaryOfDepartment (int department);

    public int getMaximalSalaryOfDepartment (int department);


}
