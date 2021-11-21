package com.huce.manege.api;

import com.huce.manege.entity.DepartmentEntity;
import com.huce.manege.model.Department;
import com.huce.manege.model.DepartmentReq;
import com.huce.manege.model.Departments;
import com.huce.manege.service.DepartmentService;
import com.huce.manege.validator.DepartmentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DerpartmentController implements DepartmentApi {

    @Autowired
    DepartmentService departmentService;
    @Autowired
    DepartmentValidator departmentValidator;
    @Override
    public ResponseEntity<Department> addDepartment(DepartmentReq request) {
        departmentValidator.validateAddDepartment(request);
        Department department = departmentService.createDepartment(request);
        return new ResponseEntity<>(department,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Department> editDepartment(String id, DepartmentReq request) {
        departmentValidator.validateUpdateDepartment(id, request);
        Department department = departmentService.updateDepartment(id,request);
        return new ResponseEntity<>(department,HttpStatus.OK);
    }

    @GetMapping("/trung")
    public String hello(){
        return "trung";
    }
    @GetMapping("/departmentdelete/{id}")
    public void delete(@PathVariable("id") String id){
        departmentValidator.validateEmployeeExist(id);
        departmentService.deleteDepartment(id);
    }

    @Override
    public ResponseEntity<Department> getDepartmentID(String id) {
        departmentValidator.validateEmployeeExist(id);
        Department department = departmentService.getDepartmentID(id);
        return new ResponseEntity<>(department,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Departments> getdepartment() {
        Departments departments = new Departments();
        departments = departmentService.getAllDepartment();
        return new ResponseEntity<>(departments,HttpStatus.OK);
    }
}
