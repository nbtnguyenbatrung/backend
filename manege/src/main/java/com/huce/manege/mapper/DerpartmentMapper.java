package com.huce.manege.mapper;

import com.huce.manege.entity.DepartmentEntity;
import com.huce.manege.function.id;
import com.huce.manege.model.Department;
import com.huce.manege.model.DepartmentReq;
import com.huce.manege.repository.DerpartmentJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DerpartmentMapper {

    @Autowired
    DerpartmentJPA derpartmentJPA;
    @Autowired
    id id1;

    public DepartmentEntity toEntityFromDepartmentDTO (DepartmentReq req){
        DepartmentEntity departmentEntity = new DepartmentEntity();
        List<DepartmentEntity> departmentEntities =  derpartmentJPA.findAll();
        String ma ;
        if(departmentEntities.size() == 0 ){
            ma = "nv0";
        }
        else {
            ma = departmentEntities.get(departmentEntities.size() - 1).getId();
        }
        String id = "PB" + id1.Laystt(ma);
        departmentEntity.setId(id);
        departmentEntity.setName(req.getName());
        departmentEntity.setAddress(req.getAddress());
        departmentEntity.setPhone(req.getPhone());
        departmentEntity.setStatus(DepartmentReq.StatusEnum.PENDING.name());
        return departmentEntity;
    }

    public Department toDepartmentFromDepartmentEntity(DepartmentEntity departmentEntity){
        Department department = new Department();
        department.setId(departmentEntity.getId());
        department.setName(departmentEntity.getName());
        department.setAddress(departmentEntity.getAddress());
        department.setPhone(departmentEntity.getPhone());
        department.setStatus(Department.StatusEnum.fromValue(departmentEntity.getStatus()));
        return department;
    }

    public DepartmentEntity toEntity(DepartmentReq departmentReq , DepartmentEntity departmentEntity){

        departmentEntity.setAddress(departmentReq.getAddress());
        departmentEntity.setName(departmentReq.getName());
        departmentEntity.setPhone(departmentReq.getPhone());
        departmentEntity.setStatus(departmentReq.getStatus().name());
        return departmentEntity;
    }


}
