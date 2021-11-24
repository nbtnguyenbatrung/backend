package com.HUCE.miniblogs.repository;

import com.HUCE.miniblogs.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactEntity,String> {
}
