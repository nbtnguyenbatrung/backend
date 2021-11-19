package com.huce.manege.repository;

import com.huce.manege.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeJPA extends JpaRepository <EmployeeEntity, String> {
     List<EmployeeEntity> findAll();
}
