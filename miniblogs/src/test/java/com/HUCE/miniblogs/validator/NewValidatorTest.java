package com.HUCE.miniblogs.validator;

import com.HUCE.miniblogs.exception.BadRequestException;
import com.HUCE.miniblogs.mock.NewData;
import com.HUCE.miniblogs.model.NewReq;
import com.HUCE.miniblogs.repository.NewRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class NewValidatorTest {

    @InjectMocks
    NewValidator newValidator;

    @Mock
    NewRepository newRepository;

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void validateAddNew(){
        newValidator.validateAddNew(NewData.mockNewreq());
    }

    @Test
    public void validateAddNewShowExceptioWhenRequiredFieldIsNull(){
        expected.expect(BadRequestException.class);
        expected.expectMessage("New title is requested");

        NewReq newReq = NewData.mockNewreq();
        newReq.setTitle("");

        newValidator.validateAddNew(newReq);
    }

}