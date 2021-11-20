package com.huce.manege.api;

import com.huce.manege.model.Employee;
import com.huce.manege.model.EmployeeRequest;
import com.huce.manege.model.Employees;
import com.huce.manege.service.EmployeeService;
import com.huce.manege.validator.EmployeeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController implements EmployeeApi{

    @Autowired
    EmployeeService employeeService ;
    @Autowired
    EmployeeValidator employeeValidator;


    @Override
    public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeRequest request) {
        employeeValidator.validateAddEmployee(request);
        Employee employee = employeeService.createEmployee(request);
        return new ResponseEntity<>(employee , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteEmployee(String id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Employee> editEmployee(String id, EmployeeRequest request) {
        employeeValidator.validateUpdateEmployee(id,request);
        Employee employee = new Employee();
        employee = employeeService.updateEmployee(id , request);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Employee> getEmployeeID(String id) {
        employeeValidator.validateEmployeeExist(id);
        Employee employee = employeeService.getemployeeID(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Employees> getemployee() {
        Employees employees = employeeService.getAllEmployee();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }
}
