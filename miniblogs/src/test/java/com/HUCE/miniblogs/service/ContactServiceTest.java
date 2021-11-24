package com.HUCE.miniblogs.service;

import com.HUCE.miniblogs.mapper.ContactMapper;
import com.HUCE.miniblogs.mock.ContactData;
import com.HUCE.miniblogs.repository.ContactRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class ContactServiceTest {
    @InjectMocks
    ContactService contactService;

    @Mock
    ContactRepository contactRepository;
    @Mock
    ContactMapper mapper;

    @Test
    public void addcontact(){
        contactService.addcontact(ContactData.mockContactreq());
    }

    @Test
    public void getallcontact(){
        contactService.getallcontact();
    }

    @Test
    public void updatecontact(){
        contactService.updatecontact(ContactData.ID,ContactData.mockContactreq());
    }

}