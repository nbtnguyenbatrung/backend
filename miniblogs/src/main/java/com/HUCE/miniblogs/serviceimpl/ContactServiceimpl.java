package com.HUCE.miniblogs.serviceimpl;

import com.HUCE.miniblogs.model.Contact;
import com.HUCE.miniblogs.model.ContactReq;

public interface ContactServiceimpl {
    Contact addcontact(ContactReq req);
    Contact getallcontact(String id) ;
    Contact updatecontact(String id, ContactReq req);
}
