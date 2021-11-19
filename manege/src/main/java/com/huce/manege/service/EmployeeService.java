package com.huce.manege.service;

import com.huce.manege.entity.EmployeeEntity;
import com.huce.manege.mapper.EmployeeMapper;
import com.huce.manege.model.EmployeeRequest;
import com.huce.manege.model.Employees;
import com.huce.manege.repository.EmployeeJPA;
import com.huce.manege.serviceimpl.EmployeeServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService  implements EmployeeServiceimpl {

    @Autowired
    private EmployeeJPA employeejpa;
    @Autowired
    private EmployeeMapper mapper ;

    @Override
    public EmployeeEntity createEmployee(EmployeeRequest req) {
        EmployeeEntity employee = mapper.toEntityFromEmployeeDTO(req);
        employee = employeejpa.save(employee);
        return employee;
    }

    @Override
    public EmployeeEntity updateEmployee(String id, EmployeeRequest req) {
        return null;
    }

    @Override
    public void deleteEmployee(String id) {

    }

    @Override
    public Employees getAllEmployee() {
        return null;
    }

    @Override
    public EmployeeEntity getemployeeID(String id) {
        return null;
    }
}
