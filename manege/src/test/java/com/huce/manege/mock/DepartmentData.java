package com.huce.manege.mock;

import com.huce.manege.entity.DepartmentEntity;
import com.huce.manege.model.Department;
import com.huce.manege.model.DepartmentReq;
import com.huce.manege.model.Departments;
import org.springframework.security.core.parameters.P;

import java.util.Arrays;
import java.util.List;

public class DepartmentData {

    public static final String PROPERTY_ID = "c73095df-a31d-45a0-8d57-8c43108830c7";
    public static final String NAME = "develop";
    public static final String ADDRESS = "Dogoo Tech SJC";
    public static final String PHONE = "1231244";

    public static Department mockDepartment() {
        Department department = new Department();

        department.setId(PROPERTY_ID);
        department.setName(NAME);
        department.setAddress(ADDRESS);
        department.setPhone(PHONE);
        department.setStatus(Department.StatusEnum.PENDING);

        return department;
    }

    public static Departments mockDepartments() {
        Departments departments = new Departments();

        departments.add(mockDepartment());

        return departments;
    }

    public static DepartmentReq mockDepartmentReq() {
        DepartmentReq departmentReq = new DepartmentReq();

        departmentReq.setName(NAME);
        departmentReq.setAddress(ADDRESS);
        departmentReq.setPhone(PHONE);
        departmentReq.setStatus(DepartmentReq.StatusEnum.PENDING);

        return departmentReq;
    }


    public static DepartmentEntity mockDepartmentEntity() {
        DepartmentEntity entity = new DepartmentEntity();

        entity.setId(PROPERTY_ID);
        entity.setName(NAME);
        entity.setAddress(ADDRESS);
        entity.setPhone(PHONE);
        entity.setStatus("PENDING");

        return entity;
    }

    public static List<DepartmentEntity> mockDepartmentEntities() {
        return Arrays.asList(mockDepartmentEntity());
    }
}
