package com.huce.manege.mapper;

import com.huce.manege.entity.DepartmentEntity;
import com.huce.manege.model.DepartmentReq;
import com.huce.manege.repository.DerpartmentJPA;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DerpartmentMapper {

    public DepartmentEntity toEntityFromDepartmentDTO (DepartmentReq req){
        DepartmentEntity department = new DepartmentEntity();
        DerpartmentJPA derpartmentJPA = null;
        List<DepartmentEntity> departments =  derpartmentJPA.findAll();
        String ma ;
        if(departments == null ){
            ma = "nv0";
        }
        else {
            ma = departments.get(departments.size() - 1).getId();
        }
        department.setId("NV"+ma);
        department.setName(req.getName());
        department.setAddress(req.getAddress());
        department.setPhone(req.getPhone());
        department.setStatus(DepartmentReq.StatusEnum.PENDING.name());
        return department;
    }

}
