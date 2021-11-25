package com.HUCE.miniblogs.api;

import com.HUCE.miniblogs.mock.ContactData;
import com.HUCE.miniblogs.mock.NewData;
import com.HUCE.miniblogs.model.Contact;
import com.HUCE.miniblogs.model.ContactReq;
import com.HUCE.miniblogs.service.ContactService;
import com.HUCE.miniblogs.validator.ContactValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ContactControllerTest {

    private final String API_KEY = "MOCK_API_KEY";

    @InjectMocks
    ContactController controller;

    @Mock
    ContactService service;

    @Mock
    ContactValidator validator;

    @Test
    public void addContact(){
        when(service.addcontact(any(ContactReq.class)))
                .thenReturn(ContactData.mockContact());

        ResponseEntity<Contact> responseEntity =
                controller.addContact(API_KEY, ContactData.mockContactreq());

        assertStatus200(responseEntity.getStatusCode());
        assertProperty(responseEntity.getBody());
    }

    @Test
    public void updateContact(){
        when(service.updatecontact(anyString(), any(ContactReq.class)))
                .thenReturn(ContactData.mockContact());

        ResponseEntity<Contact> responseEntity =
                controller.updateContact(API_KEY, ContactData.ID, ContactData.mockContactreq());

        assertStatus200(responseEntity.getStatusCode());
        assertProperty(responseEntity.getBody());
    }

    @Test
    public void getAllContact(){
        when(service.getallcontact())
                .thenReturn(ContactData.mockContact());
        ResponseEntity<Contact> responseEntity =
                controller.getAllContact(API_KEY);

        assertStatus200(responseEntity.getStatusCode());
        assertProperty(responseEntity.getBody());

    }

    private void assertProperty(Contact actual) {
        assertThat(actual.getId(), is(ContactData.ID));
        assertThat(actual.getName(), is(ContactData.NAME));
        assertThat(actual.getEmail(), is(ContactData.EMAIL));
        assertThat(actual.getMessage(), is(ContactData.MESSAGE));
    }



    private void assertStatus200(HttpStatus actual) {
        assertThat(actual, is(HttpStatus.OK));
    }
}