package com.huce.manege.serviceimpl;

import com.huce.manege.entity.EmployeeEntity;
import com.huce.manege.model.EmployeeRequest;
import com.huce.manege.model.Employees;

public interface EmployeeServiceimpl {
    EmployeeEntity createEmployee(EmployeeRequest req);
    EmployeeEntity updateEmployee(String id , EmployeeRequest req);
    void deleteEmployee(String id );
    Employees getAllEmployee();
    EmployeeEntity getemployeeID(String id);
}

