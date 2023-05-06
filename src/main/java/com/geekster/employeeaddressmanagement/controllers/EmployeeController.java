package com.geekster.employeeaddressmanagement.controllers;
import com.geekster.employeeaddressmanagement.services.EmployeeService;
import com.geekster.employeeaddressmanagement.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping(value = "/" )
    String addEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping(value = "/getAll")
    public List<Employee> getAllEmployee(){
        return employeeService.fetchAllEmployee();
    }

    @GetMapping(value = "/{employeeId}")
    public Optional<Employee> getEmployeeById(@PathVariable Long employeeId){
        return employeeService.fetchEmployeeById(employeeId);
    }

    @PutMapping(value = "/{employeeId}/firstName/{firstName}/lastName/{lastName}")
    public String updateEmployeeNameById(@PathVariable Long employeeId, @PathVariable String firstName,@PathVariable String lastName){
        return employeeService.modifyEmployeeNameById(employeeId,firstName,lastName);
    }

    @DeleteMapping(value = "/{employeeId}")
    public String deleteEmployeeById(@PathVariable Long employeeId){
        return employeeService.removeEmployeeById(employeeId);
    }


}
