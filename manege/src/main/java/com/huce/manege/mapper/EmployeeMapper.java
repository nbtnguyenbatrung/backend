package com.huce.manege.mapper;

import com.huce.manege.dto.EmployeeDTO;
import com.huce.manege.entity.EmployeeEntity;
import com.huce.manege.model.Employee;
import com.huce.manege.model.EmployeeRequest;
import com.huce.manege.repository.EmployeeJPA;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeMapper {
    public EmployeeEntity toEntityFromEmployeeDTO (EmployeeRequest req){
        EmployeeEntity employee = new EmployeeEntity();
        EmployeeJPA employeejpa = null;
        List<EmployeeEntity> employees =  employeejpa.findAll();
        String ma ;
        if(employees == null ){
            ma = "nv0";
        }
        else {
            ma = employees.get(employees.size() - 1).getId();
        }
        employee.setId("NV"+ma);
        employee.setName(req.getName());
        employee.setEmail(req.getEmail());
        employee.setAddress(req.getAddress());
        employee.(req.getDepartmentid());
        return employee;
    }

    public Employee toEmployeeFromEmployeeEntity(EmployeeEntity employeeEntity){
        Employee employee = new Employee();
        employee.setId(employeeEntity.getId());
        employee.setAddress(employeeEntity.getAddress());
        employee.setName(employeeEntity.getName());
        employee.setEmail(employeeEntity.getEmail());

    }

    public EmployeeDTO toDto (EmployeeEntity employee){
        EmployeeDTO employeedto = new EmployeeDTO();

        employeedto.setId(employee.getId());
        employeedto.setName(employee.getName());
        employeedto.setEmail(employee.getEmail());
        employeedto.setAddress(employee.getAddress());

        return employeedto;

    }
}
