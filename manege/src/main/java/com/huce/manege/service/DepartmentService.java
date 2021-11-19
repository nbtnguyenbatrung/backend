package com.huce.manege.service;

import com.huce.manege.entity.DepartmentEntity;
import com.huce.manege.mapper.DerpartmentMapper;
import com.huce.manege.model.Department;
import com.huce.manege.model.DepartmentReq;
import com.huce.manege.model.Departments;
import com.huce.manege.repository.DerpartmentJPA;
import com.huce.manege.serviceimpl.DepartmentServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService implements DepartmentServiceimpl {

    @Autowired
    private DerpartmentJPA derpartmentJPA;
    @Autowired
    private DerpartmentMapper mapper;

    @Override
    public Department createDepartment(DepartmentReq req) {
        DepartmentEntity departmentEntity = mapper.toEntityFromDepartmentDTO(req);
        departmentEntity = derpartmentJPA.save(departmentEntity);
        Department department = mapper.toDepartmentFromDepartmentEntity(departmentEntity);
        return department;
    }

    @Override
    public Department updateDepartment(String id, DepartmentReq req) {
        DepartmentEntity olddepartmentEntity = derpartmentJPA.getById(id);
        DepartmentEntity departmentEntity = mapper.toEntity(req,olddepartmentEntity);
        departmentEntity = derpartmentJPA.save(departmentEntity);
        Department department = mapper.toDepartmentFromDepartmentEntity(departmentEntity);
        return department;
    }

    @Override
    public void deleteDepartment(String id) {
        DepartmentEntity departmentEntity = derpartmentJPA.getById(id);
        departmentEntity.setStatus("REJECTED");
        derpartmentJPA.save(departmentEntity);
    }

    @Override
    public Departments getAllDepartment() {
        return null;
    }

    @Override
    public Department getDepartmentID(String id) {
        return null;
    }
}
