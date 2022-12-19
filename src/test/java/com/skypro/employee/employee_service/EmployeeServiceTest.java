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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @InjectMocks
    private EmployeeRepository employeeRepository;
    @Mock
    private EmployeeService employeeService;

    private List<Employee> actualEmployee;

    @BeforeEach
    public void setUp() {
        Employee employee1 = new Employee ("Ivan", "Ivanov", 2, 10_000);
        Employee employee2 = new Employee ("Petr", "Ivanov", 3, 30_000);
        Employee employee3 = new Employee ("Ivan", "Petrov", 5, 20_000);

        actualEmployee = new ArrayList<> (List.of (employee1, employee2, employee3));

        employeeRepository.addEmployee (employee1);
        employeeRepository.addEmployee (employee2);
        employeeRepository.addEmployee (employee3);


    }

    // Нужна помощь, что не так? почему объекты не попадают в Аррей Лист в репозитории? EmployeeRepository  стр 12 и как переделать?
    @Test
    public void getAllEmployees() {
         ArrayList<Employee> expected = employeeRepository.getEmployeeList ();
        assertEquals (expected, actualEmployee);

    }

    @Test
    public void shouldSallarySum() {
        final int actual = actualEmployee.stream ()
                .mapToInt (Employee::getSalary)
                .sum ();
        final int expected = employeeService.getSallarySum ();
        assertEquals (expected, actual);
    }

    @Test
    public void shouldMinSallary() {
        final int actual = actualEmployee.stream ()
                .mapToInt (Employee::getSalary)
                .min ().orElse (0);
        final int expected = employeeService.getMinimalSalary ();
        assertEquals (expected, actual);
    }

    @Test
    public void shouldMaxSallary() {
        final int actual = actualEmployee.stream ()
                .mapToInt (Employee::getSalary)
                .max ().orElse (0);
        final int expected = employeeService.getMaximalSalary ();
        assertEquals (expected, actual);
    }

    @Test
    public void shouldHighSalary() {


        int sum1 = 0;
        for (Employee employee : actualEmployee) {
            sum1 = sum1 + employee.getSalary ();
        }
        int overageSalary = (sum1 / actualEmployee.size ());
        final List<Employee> actual = new LinkedList<> ();
        for (Employee employee1 : actual) {
            if (employee1.getSalary () >= overageSalary) {
                actual.add (employee1);
            }
        }

        final List<Employee> expected = employeeService.getHighSalary ();
        assertEquals (expected, actual);
    }
}


