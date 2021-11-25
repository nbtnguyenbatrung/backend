package com.HUCE.miniblogs.service;

import com.HUCE.miniblogs.entity.ContactEntity;
import com.HUCE.miniblogs.mapper.ContactMapper;
import com.HUCE.miniblogs.model.Contact;
import com.HUCE.miniblogs.model.ContactReq;
import com.HUCE.miniblogs.repository.ContactRepository;
import com.HUCE.miniblogs.serviceimpl.ContactServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService implements ContactServiceimpl {

    @Autowired
    ContactRepository contactRepository;
    @Autowired
    ContactMapper mapper;
    @Override
    public Contact addcontact(ContactReq req) {
        ContactEntity contactEntity = mapper.toEntityfromContact(req);
        contactEntity = contactRepository.save(contactEntity);
        Contact contact = mapper.toContactfromEntity(contactEntity);
        return contact;
    }

    @Override
    public Contact getallcontact() {
        List<ContactEntity> contactEntity = contactRepository.findAll();
        Contact contact = new Contact();
        for(ContactEntity contactEntity1 : contactEntity){
            contact = mapper.toContactfromEntity(contactEntity1);
        }
        return contact;
    }

    @Override
    public Contact updatecontact(String id,ContactReq req) {
        ContactEntity contactEntity = contactRepository.getById(id);
        contactEntity = mapper.toEnity(req,contactEntity);
        contactEntity = contactRepository.save(contactEntity);
        Contact contact = mapper.toContactfromEntity(contactEntity);
        return contact;
    }
}
