package com.huce.manege.repository;

import com.huce.manege.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DerpartmentJPA extends JpaRepository<DepartmentEntity,String> {

}
