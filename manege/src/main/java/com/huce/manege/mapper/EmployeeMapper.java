package com.huce.manege.mapper;

import com.huce.manege.entity.EmployeeEntity;
import com.huce.manege.function.id;
import com.huce.manege.model.Employee;
import com.huce.manege.model.EmployeeRequest;
import com.huce.manege.repository.EmployeeJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeMapper {

    @Autowired
    EmployeeJPA employeeJPA ;
    @Autowired
    id id1;

    public EmployeeEntity toEntityFromEmployeeDTO (EmployeeRequest req){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        List<EmployeeEntity> employeeEntities =  employeeJPA.findAll();
        String ma ;
        if(employeeEntities.size() == 0 ){
            ma = "nv0";
        }
        else {
            ma = employeeEntities.get(employeeEntities.size() - 1).getId();
        }

        String id = "NV" + id1.Laystt(ma);
        employeeEntity.setId(id);
        employeeEntity.setName(req.getName());
        employeeEntity.setEmail(req.getEmail());
        employeeEntity.setAddress(req.getAddress());
        return employeeEntity;
    }

    public Employee toEmployeeFromEmployeeEntity(EmployeeEntity employeeEntity){
        Employee employee = new Employee();
        employee.setId(employeeEntity.getId());
        employee.setAddress(employeeEntity.getAddress());
        employee.setName(employeeEntity.getName());
        employee.setEmail(employeeEntity.getEmail());
        employee.setDepartmentid(employeeEntity.getDerpartment().getId());
        return employee;
    }

}
