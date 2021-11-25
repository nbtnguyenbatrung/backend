package com.HUCE.miniblogs.validator;

import com.HUCE.miniblogs.exception.BadRequestException;
import com.HUCE.miniblogs.exception.NotFoundException;
import com.HUCE.miniblogs.mock.ContactData;
import com.HUCE.miniblogs.model.ContactReq;
import com.HUCE.miniblogs.repository.ContactRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ContactValidatorTest {
    @InjectMocks
    ContactValidator contactValidator;

    @Mock
    ContactRepository contactRepository;

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void validateAddContact(){
        contactValidator.validateAddContact(ContactData.mockContactreq());
    }

    @Test
    public void validateAddContactShowExceptionWhenRequairedFieldNull() {
        expected.expect(BadRequestException.class);
        expected.expectMessage("Contact name is requested");
        ContactReq contactReq = ContactData.mockContactreq();
        contactReq.setName("");
        contactValidator.validateAddContact(contactReq);
    }

    @Test
    public void validateUpdateContact(){
        when(contactRepository.existsById(ContactData.ID))
                .thenReturn(true);
        contactValidator.validateUpdateContact(ContactData.ID,ContactData.mockContactreq());
    }

    @Test
    public void validateUpdateContactShowExceptionWhenWrongId() {
        expected.expect(NotFoundException.class);
        expected.expectMessage("Contact does not exist");

        when(contactRepository.existsById(ContactData.ID)).thenReturn(false);

        contactValidator.validateUpdateContact(ContactData.ID, ContactData.mockContactreq());
    }
}