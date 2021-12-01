package com.huce.manege.service;

import com.huce.manege.entity.ApiKeyEntity;
import com.huce.manege.repository.ApiKeyRepository;
import com.huce.manege.serviceimpl.ApiKeyServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class ApikeyService implements ApiKeyServiceimpl, UserDetailsService {

    @Autowired
    ApiKeyRepository apiKeyRepository;
    @Autowired
    PasswordEncoder passwordEncoder ;

    @Override
    public ApiKeyEntity getusername(String username) {
        return apiKeyRepository.findByUsername(username);
    }

    @Override
    public ApiKeyEntity saveapikey(ApiKeyEntity apiKeyEntity) {
        apiKeyEntity.setPassword(passwordEncoder.encode(apiKeyEntity.getPassword()));
        return apiKeyRepository.save(apiKeyEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApiKeyEntity apiKeyEntity = apiKeyRepository.findByUsername(username);
        if(apiKeyEntity == null ){
            throw new UsernameNotFoundException(" không có user này trong hệ thống ") ;
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(apiKeyEntity.getRole()));
        return new org.springframework.security.core.userdetails.User(apiKeyEntity.getUsername() , apiKeyEntity.getPassword() , authorities);
    }
}
