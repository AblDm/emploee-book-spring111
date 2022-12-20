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

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.skypro.employee.EmployeeFabric.listEmployee;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith (MockitoExtension.class)
public class DepartmentServiceImplTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @BeforeEach
    public void setUp(){
        when(employeeRepository.getEmployeeList ()).thenReturn (listEmployee ());
    }


    @Test
    //getExistingDep
    public void shouldReturnExistDepartments() {
        final Set<Integer> actual = listEmployee ().stream ()
                .map (Employee::getDepartmentId)
                .collect (Collectors.toSet ());
        final Set<Integer> expected = departmentService.getExistingDepartments ();

        assertEquals (expected, actual);
    }

     @Test
    //getEmployeesFromDepartment
    public void shouldReturnEmployeesFromDepartment() {
        final int department = 1;

        final List <Employee>actual = listEmployee ().stream ()
                .filter (e -> e.getDepartmentId () == department)
                .toList ();
        final List <Employee> expected = departmentService.getEmployeeFromDepartment (department);

        assertEquals (expected, actual);
    }

    @Test //getSalarySumOfDepartment
    public void shouldReturnSalarySumOfDepartment() {
        final int department = 1;

        final int actual = listEmployee ().stream ()
                .filter (e -> e.getDepartmentId () == department)
                .mapToInt (Employee::getSalary)
                .sum ();
        final int expected = departmentService.getSalarySumOfDepartment (department);

        assertEquals (expected, actual);
    }

    @Test
    public void shouldMaximalSalaryOfDepartment() {
        final int department = 1;

        final int actual = listEmployee ().stream ()
                .filter (e -> e.getDepartmentId () == department)
                .mapToInt (Employee::getSalary)
                .max ().orElse (0);

        final int expected = departmentService.getMaximalSalaryOfDepartment (department);

        assertEquals (expected, actual);
    }

    @Test
    public void shouldMinimalSalaryOfDepartment() {
        final int department = 1;

        final int actual = listEmployee ().stream ()
                .filter (e -> e.getDepartmentId () == department)
                .mapToInt (Employee::getSalary)
                .max ().orElse (0);
        final int expected = departmentService.getMinimalSalaryOfDepartment (department);

        assertEquals (expected, actual);
    }
    @Test
    public void shouldEmployeeByDepartment(){
        final Map<Integer, List <Employee>> actual=
                listEmployee ().stream ().map(Employee::getDepartmentId).collect(Collectors.toSet()).stream ()
                        .collect(Collectors.toMap (dept->dept,
                                dept -> listEmployee ().stream ().filter ( e ->e.getDepartmentId () == dept)
                                        .collect(Collectors.toList ())));
        final  Map<Integer, List <Employee>> expected = departmentService.getEmployeeByDepartment ();

        assertEquals (expected, actual);
    }



}