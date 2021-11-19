package com.huce.manege.serviceimpl;


import com.huce.manege.model.Employee;
import com.huce.manege.model.EmployeeRequest;
import com.huce.manege.model.Employees;

public interface EmployeeServiceimpl {
    Employee createEmployee(EmployeeRequest req);
    Employee updateEmployee(String id , EmployeeRequest req);
    void deleteEmployee(String id );
    Employees getAllEmployee();
    Employee getemployeeID(String id);
}

