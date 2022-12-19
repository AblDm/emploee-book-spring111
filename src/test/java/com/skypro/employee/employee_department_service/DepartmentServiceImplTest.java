package com.skypro.employee.employee_department_service;

import com.skypro.employee.model.Employee;
import com.skypro.employee.repositories.EmployeeRepository;
import com.skypro.employee.service.department_service.DepartmentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith (MockitoExtension.class)
public class DepartmentServiceImplTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    private List <Employee> actualEmployee;

    @BeforeEach
    public void setUp(){
        Employee employee1 = new Employee ("Ivan","Ivanov", 20_000, 1);
        Employee employee2 = new Employee ("Petr","Ivanov", 30_000, 3);
        Employee employee3 = new Employee ("Ivan","Petrov", 50_000, 2);

        actualEmployee = new ArrayList<> (List.of (employee1, employee2, employee3));
    }


    @Test
    //getExistingDep
    public void shouldReturnExistDepartments() {
        final Set<Integer> actual = actualEmployee.stream ()
                .map (Employee::getDepartmentId)
                .collect (Collectors.toSet ());
        final Set<Integer> expected = departmentService.getExistingDepartments ();

        assertEquals (expected, actual);
    }

     @Test
    //getEmployeesFromDepartment
    public void shouldReturnEmployeesFromDepartment() {
        final int department = 1;

        final List <Employee>actual = actualEmployee.stream ()
                .filter (e -> e.getDepartmentId () == department)
                .toList ();
        final List <Employee> expected = departmentService.getEmployeeFromDepartment (department);

        assertEquals (expected, actual);
    }

    @Test //getSalarySumOfDepartment
    public void shouldReturnSalarySumOfDepartment() {
        final int department = 1;

        final int actual = actualEmployee.stream ()
                .filter (e -> e.getDepartmentId () == department)
                .mapToInt (Employee::getSalary)
                .sum ();
        final int expected = departmentService.getSalarySumOfDepartment (department);

        assertEquals (expected, actual);
    }

    @Test
    public void shouldMaximalSalaryOfDepartment() {
        final int department = 1;

        final int actual = actualEmployee.stream ()
                .filter (e -> e.getDepartmentId () == department)
                .mapToInt (Employee::getSalary)
                .max ().orElse (0);

        final int expected = departmentService.getMaximalSalaryOfDepartment (department);

        assertEquals (expected, actual);
    }

    @Test
    public void shouldMinimalSalaryOfDepartment() {
        final int department = 1;

        final int actual = actualEmployee.stream ()
                .filter (e -> e.getDepartmentId () == department)
                .mapToInt (Employee::getSalary)
                .max ().orElse (0);
        final int expected = departmentService.getMinimalSalaryOfDepartment (department);

        assertEquals (expected, actual);
    }
    @Test
    public void shouldEmployeeByDepartment(){
        final Map<Integer, List <Employee>> actual=
                actualEmployee.stream ().map(Employee::getDepartmentId).collect(Collectors.toSet()).stream ()
                        .collect(Collectors.toMap (dept->dept,
                                dept -> actualEmployee.stream ().filter ( e ->e.getDepartmentId () == dept)
                                        .collect(Collectors.toList ())));
        final  Map<Integer, List <Employee>> expected = departmentService.getEmployeeByDepartment ();

        assertEquals (expected, actual);
    }



}
