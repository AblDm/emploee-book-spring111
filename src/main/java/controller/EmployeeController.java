package controller;

import com.skypro.employee.model.Employee;
import com.skypro.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * GET - Получение ресурсов или надора ресурсов
 * POST - Создание ресурса
 * PUT - Модификация ресурсов
 * PATCH - Частичная модификация ресурсов
 * DELETE - удаление ресурсов
 */

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController (EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @GetMapping("/employees")
    public Collection<Employee> getAllEmployees(){
      return this.employeeService.getAllEmployees ();
    }

}
