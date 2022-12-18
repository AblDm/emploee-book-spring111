package com.skypro.employee.service.department_service;


import com.skypro.employee.model.Employee;
import com.skypro.employee.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public
class DepartmentServiceImpl implements com.skypro.employee.service.DepartmentService {
    private final EmployeeRepository employeeRepository;


    DepartmentServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
     public Set<Integer> getExistingDepartments() {
         return employeeRepository.getEmployeeArrayList ().stream ()
                 .map (Employee::getDepartmentId)
                 .collect(Collectors.toSet());
     }

     @Override
     public Map<Integer, List<Employee>> getEmployeeByDepartment() {
         return getExistingDepartments ().stream ()
                 .collect (Collectors.toMap (dept ->dept, this::getEmployeeFromDepartment));
     }

     @Override
     public List<Employee> getEmployeeFromDepartment(int department) {
         return employeeRepository.getEmployeeArrayList ().stream ()
                 .filter (employee -> employee.getDepartmentId () == department)
                 .collect(Collectors.toList ()) ;
     }

     @Override
     public int getSalarySumOfDepartment(int department) {
         return getEmployeeFromDepartment (department).stream ()
                 .mapToInt (Employee :: getSalary)
                 .sum ();
     }

     @Override
     public int getMinimalSalaryOfDepartment(int department) {
         return getEmployeeFromDepartment (department).stream ()
                 .mapToInt (Employee :: getSalary)
                 .min ().orElse (0);
     }

     @Override
     public int getMaximalSalaryOfDepartment(int department) {
         return getEmployeeFromDepartment (department).stream ()
                 .mapToInt (Employee :: getSalary)
                 .max ().orElse (0);
     }
 }
