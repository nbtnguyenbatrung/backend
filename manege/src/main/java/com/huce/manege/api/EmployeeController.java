package com.huce.manege.api;

import com.huce.manege.model.Employee;
import com.huce.manege.model.EmployeeRequest;
import com.huce.manege.model.Employees;
import com.huce.manege.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController implements EmployeeApi{

    @Autowired
    EmployeeService employeeService ;

    @Override
    public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeRequest request) {
        Employee employee = employeeService.createEmployee(request);
        return new ResponseEntity<>(employee , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteEmployee(String id) {
        return null;
    }

    @Override
    public ResponseEntity<Employee> editEmployee(String id, EmployeeRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Employee> getEmployeeID(String id) {
        return null;
    }

    @Override
    public ResponseEntity<Employees> getemployee() {

        return null;
    }
}
