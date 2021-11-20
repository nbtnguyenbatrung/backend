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

import java.util.List;

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
        EmployeeEntity employeeEntity = employeejpa.getById(id);
        employeeEntity = mapper.toEntity(req,employeeEntity);
        employeeEntity = employeejpa.save(employeeEntity);
        Employee employee = mapper.toEmployeeFromEmployeeEntity(employeeEntity);
        return employee;
    }

    @Override
    public void deleteEmployee(String id) {
        EmployeeEntity employeeEntity = employeejpa.getById(id);
        employeejpa.delete(employeeEntity);
    }

    @Override
    public Employees getAllEmployee() {
        List<EmployeeEntity> employeeEntities = employeejpa.findAll();
        Employees employees = new Employees();
        for (EmployeeEntity employeeEntity : employeeEntities){
            Employee employee = mapper.toEmployeeFromEmployeeEntity(employeeEntity);
            employees.add(employee);
        }
        return employees;
    }

    @Override
    public Employee getemployeeID(String id) {
        EmployeeEntity employeeEntity = employeejpa.getById(id);
        Employee employee = mapper.toEmployeeFromEmployeeEntity(employeeEntity);
        return employee;
    }
}
