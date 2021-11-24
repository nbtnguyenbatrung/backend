package com.HUCE.miniblogs.repository;

import com.HUCE.miniblogs.entity.ApiKeyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApiKeyRepository extends JpaRepository<ApiKeyEntity,Long> {
    Optional<ApiKeyEntity> findByKey(String key);
}
