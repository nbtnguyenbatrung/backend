package com.HUCE.miniblogs.api;

import com.HUCE.miniblogs.model.Contact;
import com.HUCE.miniblogs.model.ContactReq;
import org.springframework.http.ResponseEntity;

public class ContactController implements ContactApi{

    @Override
    public ResponseEntity<Contact> addContact(String apikey, ContactReq request) {
        return null;
    }

    @Override
    public ResponseEntity<Contact> getAllContact(String apikey) {
        return null;
    }

    @Override
    public ResponseEntity<Contact> updateContact(String apikey, String id, ContactReq request) {
        return null;
    }
}
