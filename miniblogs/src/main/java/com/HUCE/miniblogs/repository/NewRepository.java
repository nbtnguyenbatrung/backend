package com.HUCE.miniblogs.repository;

import com.HUCE.miniblogs.entity.NewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewRepository extends JpaRepository<NewEntity,String> {
    boolean existsById(String id);
}
