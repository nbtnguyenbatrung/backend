package com.HUCE.miniblogs.mock;

import com.HUCE.miniblogs.entity.ContactEntity;
import com.HUCE.miniblogs.model.Contact;
import com.HUCE.miniblogs.model.ContactReq;

public class ContactData {
    public static final String ID = "c73095df-a31d-45a0-8d57-8c43108830c7";
    public static final String NAME = " trung ";
    public static final String EMAIL = " trung@gmail.com ";
    public static final String MESSAGE = " trung@gmail.com ";

    public static Contact mockContact() {
        Contact contact = new Contact();

        contact.setId(ID);
        contact.setName(NAME);
        contact.setEmail(EMAIL);
        contact.setMessage(MESSAGE);
        return contact;
    }

    public static ContactReq mockContactreq() {
        ContactReq contactReq = new ContactReq();

        contactReq.setName(NAME);
        contactReq.setEmail(EMAIL);
        contactReq.setMessage(MESSAGE);
        return contactReq;
    }

    public static ContactEntity mockContactEntity(){
        ContactEntity contactEntity = new ContactEntity();

        contactEntity.setId(ID);
        contactEntity.setName(NAME);
        contactEntity.setEmail(EMAIL);
        contactEntity.setMessage(MESSAGE);
        return contactEntity;
    }
}
