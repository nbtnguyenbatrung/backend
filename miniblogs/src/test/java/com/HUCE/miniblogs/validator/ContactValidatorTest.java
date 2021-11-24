package com.HUCE.miniblogs.validator;

import com.HUCE.miniblogs.repository.ContactRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class ContactValidatorTest {
    @InjectMocks
    ContactValidator contactValidator;

    @Mock
    ContactRepository contactRepositoryl;

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void validateAddContact(){

    }

    @Test
    public void validateUpdateContact(){

    }

    @Test
    public void validateEmployeeExist(){

    }
}