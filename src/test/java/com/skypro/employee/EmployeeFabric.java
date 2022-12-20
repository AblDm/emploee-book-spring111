package com.skypro.employee;

import com.skypro.employee.model.Employee;

import java.util.List;

public class EmployeeFabric {
    public static final Employee EMPLOYEE1 = new Employee ("Ivan", "Ivanov", 1, 10_000);
    public static final Employee EMPLOYEE2 = new Employee ("Petr", "Ivanov", 3, 20_000);
    public static final Employee EMPLOYEE3 = new Employee ("Ivan", "Petrov", 5, 30_000);

    public static final int TOTAL_SUM = EMPLOYEE1.getSalary () + EMPLOYEE2.getSalary () + EMPLOYEE3.getSalary ();
    public static final int MIN = EMPLOYEE1.getSalary ();
    public static final int MAX = EMPLOYEE3.getSalary ();

    public static List<Employee> listEmployee(){
        return List.of (EMPLOYEE1, EMPLOYEE2, EMPLOYEE3);
    }

    public static List<Employee> listEmployeeMoreAvg(){
        return List.of (EMPLOYEE3);
    }
    public static List<Employee> listEmployeeDepartment1(){
        return List.of (EMPLOYEE1);
    }


}
