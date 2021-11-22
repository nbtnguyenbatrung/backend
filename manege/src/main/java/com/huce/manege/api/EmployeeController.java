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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeController implements EmployeeApi{

    @Autowired
    EmployeeService employeeService ;
    @Autowired
    EmployeeValidator employeeValidator;


    @Override
    public ResponseEntity<Employee> addEmployee(@RequestHeader(value="apikey") String apikey,
                                                @RequestBody EmployeeRequest request) {
        employeeValidator.validateAddEmployee(request);
        Employee employee = employeeService.createEmployee(request);
        return new ResponseEntity<>(employee , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteEmployee(@RequestHeader(value="apikey") String apikey,
                                               String id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Employee> editEmployee(@RequestHeader(value="apikey") String apikey,
                                                 String id, EmployeeRequest request) {
        employeeValidator.validateUpdateEmployee(id,request);
        Employee employee = new Employee();
        employee = employeeService.updateEmployee(id , request);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Employee> getEmployeeID(@RequestHeader(value="apikey") String apikey,
                                                  String id) {
        employeeValidator.validateEmployeeExist(id);
        Employee employee = employeeService.getemployeeID(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Employees> getemployee(@RequestHeader(value="apikey") String apikey) {
        Employees employees = employeeService.getAllEmployee();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }
}
