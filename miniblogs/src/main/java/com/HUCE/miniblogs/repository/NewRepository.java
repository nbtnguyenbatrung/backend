package com.HUCE.miniblogs.repository;

import com.HUCE.miniblogs.entity.NewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewRepository extends JpaRepository<NewEntity,String> {

}
