package com.skypro.employee.controller;

import com.skypro.employee.model.Employee;
import com.skypro.employee.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping()
    public String getExistingDepartments() {
        return "Existing departments" + departmentService.getExistingDepartments ().toString ();
    }


    @GetMapping("employees/")
    public Map <Integer, List<Employee>> getEmployeeByDepartment (){
        return departmentService.getEmployeeByDepartment();
    }

    @GetMapping("/{id}/employees/")
    public Collection <Employee> getEmployeeFromDepartment (@PathVariable ("id") int departmentId){
        return departmentService.getEmployeeFromDepartment (departmentId);
    }

    @GetMapping("/{id}/salary/sum")
    public int getSalarySumOfDepartment (@PathVariable ("id") int departmentId){
        return departmentService.getSalarySumOfDepartment(departmentId);
    }

    @GetMapping("/{id}/salary/min")
    public int getMinimalSalaryOfDepartment (@PathVariable ("id") int departmentId){
        return departmentService.getMinimalSalaryOfDepartment(departmentId);
    }
    @GetMapping("/{id}/salary/max")
    public int getMaximalSalaryOfDepartment (@PathVariable ("id") int departmentId){
        return departmentService.getMaximalSalaryOfDepartment(departmentId);
    }
}
