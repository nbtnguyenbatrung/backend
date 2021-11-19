package com.huce.manege.service;

import com.huce.manege.entity.DepartmentEntity;
import com.huce.manege.mapper.DerpartmentMapper;
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
    public DepartmentEntity createDepartment(DepartmentReq req) {
        DepartmentEntity derpartment = mapper.toEntityFromDepartmentDTO(req);
        derpartment = derpartmentJPA.save(derpartment);
        return derpartment;
    }

    @Override
    public DepartmentEntity updateDepartment(String id, DepartmentReq req) {
        return null;
    }

    @Override
    public void deleteDepartment(String id) {

    }

    @Override
    public Departments getAllDepartment() {
        return null;
    }

    @Override
    public DepartmentEntity getDepartmentID(String id) {
        return null;
    }
}
