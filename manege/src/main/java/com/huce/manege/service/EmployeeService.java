package com.huce.manege.service;

import com.huce.manege.entity.DepartmentEntity;
import com.huce.manege.entity.EmployeeEntity;
import com.huce.manege.mapper.EmployeeMapper;
import com.huce.manege.model.Employee;
import com.huce.manege.model.EmployeeRequest;
import com.huce.manege.model.Employees;
import com.huce.manege.repository.DerpartmentJPA;
import com.huce.manege.repository.EmployeeJPA;
import com.huce.manege.serviceimpl.EmployeeServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService  implements EmployeeServiceimpl {

    @Autowired
    private EmployeeJPA employeejpa;
    @Autowired
    DerpartmentJPA derpartmentJPA;
    @Autowired
    private EmployeeMapper mapper ;

    @Override
    public Employee createEmployee(EmployeeRequest req) {
        DepartmentEntity departmentEntity = derpartmentJPA.findOneByid(req.getDepartmentid());
        EmployeeEntity employeeEntity = mapper.toEntityFromEmployeeDTO(req);
        employeeEntity.setDerpartment(departmentEntity);
        employeeEntity = employeejpa.save(employeeEntity);
        Employee employee = mapper.toEmployeeFromEmployeeEntity(employeeEntity);
        return employee;
    }

    @Override
    public Employee updateEmployee(String id, EmployeeRequest req) {

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
    public Employee getemployeeID(String id) {
        return null;
    }
}
