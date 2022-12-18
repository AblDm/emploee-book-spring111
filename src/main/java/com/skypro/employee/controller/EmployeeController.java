package com.skypro.employee.controller;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import com.skypro.employee.service.employee_service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/employees")
    public Employee createEmployee (@RequestBody EmployeeRequest employeeRequest) {
        return this.employeeService.addEmployee (employeeRequest);
    }

    @GetMapping("/employee/salary/sum")
    public int getSallarySum () {
        return this.employeeService.getSallarySum();
    }
    @GetMapping("/employee/salary/min")
    public Object getMinimalSalary () {
        return this.employeeService.getMinimalSalary ();
    }
    @GetMapping("/employee/salary/max")
    public Object getMaximalSalary () {
        return this.employeeService.getMaximalSalary ();
    }


   @GetMapping("/employee/high-salary")
   public Object getHighSalary () {
   return this.employeeService.getHighSalary ();
   }

}
