package com.geekster.employeeaddressmanagement.services;

import com.geekster.employeeaddressmanagement.models.Employee;
import com.geekster.employeeaddressmanagement.repositories.IEmployeeDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    IEmployeeDao employeeDao;

    public String saveEmployee(Employee employee) {
        employeeDao.save(employee);
        return "Employee Added";
    }


    public List<Employee> fetchAllEmployee() {
        return (List<Employee>) employeeDao.findAll();
    }

    public Optional<Employee> fetchEmployeeById(Long employeeId) {
        return employeeDao.findById(employeeId);
    }

    @Transactional
    public String modifyEmployeeNameById(Long employeeId, String firstName, String lastName) {
        if(employeeId == null && firstName ==null && lastName==null) return  null;
        else if(employeeId != null) {
            employeeDao.updateEmployeeNameById(employeeId, firstName,lastName);
            return "Employee with id "+employeeId+" is updated !!";
        }
        return "Employee with id "+employeeId+" doesn't exists !!";
    }


    public String removeEmployeeById(Long employeeId) {
        if(employeeId == null) return null;
        else{
            employeeDao.deleteById(employeeId);
            return "Employee with id "+employeeId+" is removed";
        }
    }
}
