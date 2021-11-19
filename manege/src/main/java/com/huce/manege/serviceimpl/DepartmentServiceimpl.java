package com.huce.manege.serviceimpl;

import com.huce.manege.entity.DepartmentEntity;
import com.huce.manege.model.Department;
import com.huce.manege.model.DepartmentReq;
import com.huce.manege.model.Departments;

public interface DepartmentServiceimpl {
    Department createDepartment(DepartmentReq req);
    Department updateDepartment(String id , DepartmentReq req);
    void deleteDepartment(String id );
    Departments getAllDepartment();
    Department getDepartmentID(String id );
}
