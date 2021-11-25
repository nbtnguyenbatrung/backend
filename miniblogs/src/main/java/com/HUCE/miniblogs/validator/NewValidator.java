package com.HUCE.miniblogs.validator;

import com.HUCE.miniblogs.exception.BadRequestException;
import com.HUCE.miniblogs.exception.NotFoundException;
import com.HUCE.miniblogs.model.NewReq;
import com.HUCE.miniblogs.repository.NewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewValidator {
    private static final String NEW_DOES_NOT_EXIST = "New does not exist";
    private static final String TITLE_REQUEST = "New title is requested";
    private static final String CONTENT_REQUEST = "New content is requested";
    private static final String SUMMARY_REQUEST = "New summary is requested";

    @Autowired
    NewRepository newRepository;

    public void validateAddNew(NewReq request){
        checkRequiredField(request.getTitle(),TITLE_REQUEST);
        checkRequiredField(request.getContent(),CONTENT_REQUEST);
        checkRequiredField(request.getSummary(),SUMMARY_REQUEST);
    }

    public void validateNewExist(String id){
        if(newRepository.existsById(id)){
            return ;
        }
            throw new NotFoundException(NEW_DOES_NOT_EXIST);
    }

    private void checkRequiredField(String value, String errorMsg) {

        if (null == value || value.trim().isEmpty()) {
            throw new BadRequestException(errorMsg);
        }
    }

}
