package com.huce.manege.serviceimpl;

import com.huce.manege.entity.DepartmentEntity;
import com.huce.manege.model.DepartmentReq;
import com.huce.manege.model.Departments;

public interface DepartmentServiceimpl {
    DepartmentEntity createDepartment(DepartmentReq req);
    DepartmentEntity updateDepartment(String id , DepartmentReq req);
    void deleteDepartment(String id );
    Departments getAllDepartment();
    DepartmentEntity getDepartmentID(String id );
}
