package com.HUCE.miniblogs.mapper;

import com.HUCE.miniblogs.entity.ContactEntity;
import com.HUCE.miniblogs.model.Contact;
import com.HUCE.miniblogs.model.ContactReq;
import com.HUCE.miniblogs.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ContactMapper {

    @Autowired
    ContactRepository contactRepository;

    public ContactEntity toEntityfromContact(ContactReq req){
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setId(UUID.randomUUID().toString());
        contactEntity.setName(req.getName());
        contactEntity.setEmail(req.getEmail());
        contactEntity.setMessage(req.getMessage());
        return contactEntity;
    }

    public Contact toContactfromEntity(ContactEntity contactEntity){
        Contact contact = new Contact();
        contact.setId(contactEntity.getId());
        contact.setName(contactEntity.getName());
        contact.setEmail(contactEntity.getEmail());
        contact.setMessage(contactEntity.getMessage());
        return contact;
    }

    public ContactEntity toEnity(ContactReq req , ContactEntity contactEntity){
        contactEntity.setName(req.getName());
        contactEntity.setEmail(req.getEmail());
        contactEntity.setMessage(req.getMessage());
        return contactEntity;
    }
}
