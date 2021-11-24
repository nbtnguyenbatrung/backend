package com.HUCE.miniblogs.validator;

import com.HUCE.miniblogs.exception.BadRequestException;
import com.HUCE.miniblogs.exception.NotFoundException;
import com.HUCE.miniblogs.model.ContactReq;
import com.HUCE.miniblogs.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContactValidator {

    @Autowired
    ContactRepository contactRepositoryl;

    private static final String CONTACT_DOES_NOT_EXIST = "Contact does not exist";
    private static final String NAME_REQUEST = "Employee name is requested";
    private static final String EMAIL_REQUEST = "Employee email is requested";
    private static final String MESSAGE_REQUEST = "Employee mesage is requested";

    public void validateAddContact(ContactReq request){
            checkRequiredField(request.getName(),NAME_REQUEST);
        checkRequiredField(request.getEmail(),EMAIL_REQUEST);
        checkRequiredField(request.getMessage(),MESSAGE_REQUEST);
    }

    public void validateUpdateContact(String id,ContactReq request){
        checkRequiredField(request.getName(),NAME_REQUEST);
        checkRequiredField(request.getEmail(),EMAIL_REQUEST);
        checkRequiredField(request.getMessage(),MESSAGE_REQUEST);
    }

    public void validateEmployeeExist(String id) {
        if (contactRepositoryl.existsById(id)) {return;}

        throw new NotFoundException(CONTACT_DOES_NOT_EXIST);
    }

    private void checkRequiredField(String value, String errorMsg) {

        if (null == value || value.trim().isEmpty()) {
            throw new BadRequestException(errorMsg);
        }
    }
}
