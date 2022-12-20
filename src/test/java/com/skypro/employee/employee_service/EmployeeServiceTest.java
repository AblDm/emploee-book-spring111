package com.skypro.employee.employee_service;

import com.skypro.employee.model.Employee;
import com.skypro.employee.repositories.EmployeeRepository;
import com.skypro.employee.service.employee_service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.skypro.employee.EmployeeFabric.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @Mock
    private EmployeeRepository employeeRepository;
    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        when(employeeRepository.getEmployeeList ()).thenReturn (listEmployee ());
    }

    @Test
    public void getAllEmployees() {
        final List<Employee> expected = employeeService.getAllEmployees ();
        assertEquals (expected,listEmployee ());

    }

    @Test
    public void shouldSallarySum() {
        final int expected = employeeService.getSallarySum ();
        assertEquals (expected, TOTAL_SUM);
    }

    @Test
    public void shouldMinSallary() {
        final int expected = employeeService.getMinimalSalary ();
        assertEquals (expected, MIN);
    }

    @Test
    public void shouldMaxSallary() {
    final int expected = employeeService.getMaximalSalary ();
    assertEquals (expected,MAX);
     }

    @Test
    public void shouldHighSalary() {

        final List<Employee> expected = employeeService.getHighSalary ();
        assertEquals (expected,listEmployeeMoreAvg ());
    }
}


