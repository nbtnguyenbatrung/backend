package com.HUCE.miniblogs.mapper;

import com.HUCE.miniblogs.entity.ContactEntity;
import com.HUCE.miniblogs.mock.ContactData;
import com.HUCE.miniblogs.model.Contact;
import com.HUCE.miniblogs.model.ContactReq;
import com.HUCE.miniblogs.repository.ContactRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ContactMapperTest {
    @InjectMocks
    ContactMapper contactMapper ;

    @Mock
    ContactRepository contactRepository;

    @Test
    public void toEntityfromContact(){

        ContactReq contactReq = ContactData.mockContactreq();

        ContactEntity contactEntity = contactMapper.toEntityfromContact(contactReq);

        assertThat(contactEntity.getId() != null, is(true));
        assertThat(contactEntity.getName(), is(contactReq.getName()));
        assertThat(contactEntity.getEmail(), is(contactReq.getEmail()));
        assertThat(contactEntity.getMessage(), is(contactReq.getMessage()));
    }

    @Test
    public void toContactfromEntity(){
        ContactEntity contactEntity = ContactData.mockContactEntity();

        Contact contact = contactMapper.toContactfromEntity(contactEntity);

        assertThat(contact.getId(), is(contactEntity.getId()));
        assertThat(contact.getName(), is(contactEntity.getName()));
        assertThat(contact.getEmail(), is(contactEntity.getEmail()));
        assertThat(contact.getMessage(), is(contactEntity.getMessage()));

    }

    @Test
    public void toEnityForUpdate(){
        ContactEntity contactEntity = ContactData.mockContactEntity();

        when(contactRepository.getOne(ContactData.ID)).thenReturn(contactEntity);

        ContactReq contactReq = ContactData.mockContactreq();

        ContactEntity entity = contactMapper.toEnity(contactReq,contactEntity);

        assertThat(entity.getName(), is(contactReq.getName()));
        assertThat(entity.getEmail(), is(contactReq.getEmail()));
        assertThat(entity.getMessage(), is(contactReq.getMessage()));

        assertThat(entity.getId() , is(contactEntity.getId()));
        assertThat(entity.getName() , is(contactEntity.getName()));
        assertThat(entity.getEmail() , is(contactEntity.getEmail()));
        assertThat(entity.getMessage(), is(contactEntity.getMessage()));

    }
}