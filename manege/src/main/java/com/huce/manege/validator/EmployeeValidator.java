package com.huce.manege.validator;

import com.huce.manege.exception.BadRequestException;
import com.huce.manege.exception.EntityNotFoundException;
import com.huce.manege.model.Employee;
import com.huce.manege.model.EmployeeRequest;
import com.huce.manege.repository.EmployeeJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeValidator {
    private static final String EMPLOYEE_DOES_NOT_EXIST = "Employee does not exist";
    private static final String NAME_REQUEST = "Employee name is requested";
    private static final String EMAIL_REQUEST = "Employee email is requested";
    private static final String DEPARTMENTID_REQUEST = "Employee department is requested";

    @Autowired
    EmployeeJPA employeeJPA;

    public void validateAddEmployee(EmployeeRequest request) {
        checkRequiredField(request.getName(),NAME_REQUEST);
        checkRequiredField(request.getEmail(),NAME_REQUEST);
        checkRequiredField(request.getDepartmentid(),NAME_REQUEST);
    }

    public void validateUpdateEmployee(String id, EmployeeRequest request) {
        validateEmployeeExist(id);
        checkRequiredField(request.getName(),NAME_REQUEST);
        checkRequiredField(request.getEmail(),NAME_REQUEST);
        checkRequiredField(request.getDepartmentid(),NAME_REQUEST);
    }

    public void validateEmployeeExist(String id) {
        if (employeeJPA.existsById(id)) {return;}

        throw new EntityNotFoundException(EMPLOYEE_DOES_NOT_EXIST);
    }



    private void checkRequiredField(String value, String errorMsg) {

        if (null == value || value.trim().isEmpty()) {
            throw new BadRequestException(errorMsg);
        }
    }


}
