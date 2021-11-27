package com.HUCE.miniblogs.api;

import com.HUCE.miniblogs.model.Contact;
import com.HUCE.miniblogs.model.ContactReq;
import com.HUCE.miniblogs.service.ContactService;
import com.HUCE.miniblogs.validator.ContactValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin()
@RequestMapping("/api")
public class ContactController implements ContactApi{

    @Autowired
    ContactService contactService;
    @Autowired
    ContactValidator contactValidator;

    @Override
    public ResponseEntity<Contact> addContact(String apikey, ContactReq request) {
        contactValidator.validateAddContact(request);
        Contact contact = contactService.addcontact(request);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Contact> getAllContact(String apikey) {
        Contact contact = contactService.getallcontact();
        return new ResponseEntity<>(contact,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Contact> updateContact(String apikey, String id, ContactReq request) {
        contactValidator.validateUpdateContact(id,request);
        Contact contact = contactService.updatecontact(id,request);
        return new ResponseEntity<>(contact,HttpStatus.OK);
    }
}
