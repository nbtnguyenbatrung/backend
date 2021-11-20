package com.huce.manege.validator;

import com.huce.manege.exception.BadRequestException;
import com.huce.manege.exception.EntityNotFoundException;
import com.huce.manege.model.DepartmentReq;
import com.huce.manege.model.EmployeeRequest;
import com.huce.manege.repository.DerpartmentJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepartmentValidator {
    private static final String DEPARTMENT_DOES_NOT_EXIST = "Employee does not exist";
    private static final String NAME_REQUEST = "Employee name is requested";

    @Autowired
    DerpartmentJPA derpartmentJPA;

    public void validateAddDepartment(DepartmentReq request) {
        checkRequiredField(request.getName(),NAME_REQUEST);
    }

    public void validateUpdateDepartment(String id, DepartmentReq request) {
        validateEmployeeExist(id);
        checkRequiredField(request.getName(),NAME_REQUEST);
    }

    public void validateEmployeeExist(String id) {
        if (derpartmentJPA.existsById(id)) {return;}

        throw new EntityNotFoundException(DEPARTMENT_DOES_NOT_EXIST);
    }

    private void checkRequiredField(String value, String errorMsg) {

        if (null == value || value.trim().isEmpty()) {
            throw new BadRequestException(errorMsg);
        }
    }
}
