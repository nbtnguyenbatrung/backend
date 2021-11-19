package com.huce.manege.api;

import com.huce.manege.entity.DepartmentEntity;
import com.huce.manege.model.Department;
import com.huce.manege.model.DepartmentReq;
import com.huce.manege.model.Departments;
import com.huce.manege.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DerpartmentController implements DepartmentApi {

    @Autowired
    DepartmentService departmentService;
    @Override
    public ResponseEntity<Department> addDepartment(DepartmentReq request) {
        DepartmentEntity derpartment = departmentService.createDepartment(request);
        return new ResponseEntity<>(derpartment , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Department> editDepartment(String id, DepartmentReq request) {
        return null;
    }

    @Override
    public ResponseEntity<Department> getDepartmentID(String id) {
        return null;
    }

    @Override
    public ResponseEntity<Departments> getdepartment() {
        return null;
    }
}
