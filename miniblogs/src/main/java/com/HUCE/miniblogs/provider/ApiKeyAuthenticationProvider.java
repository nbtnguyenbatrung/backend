package com.HUCE.miniblogs.provider;

import com.HUCE.miniblogs.entity.ApiKeyEntity;
import com.HUCE.miniblogs.model.ApiKeyAuthenticationToken;
import com.HUCE.miniblogs.repository.ApiKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Component
public class ApiKeyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    ApiKeyRepository apiKeyRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String apikey = (String) authentication.getPrincipal();

        if(ObjectUtils.isEmpty(apikey)){
            throw new InsufficientAuthenticationException(" No API key in request");
        }else{
            Optional<ApiKeyEntity> apiKeyOptional = this.apiKeyRepository.findByKey(apikey);

            if (apiKeyOptional.isPresent()) {
                return new ApiKeyAuthenticationToken(apikey, true);
            }
            throw new BadCredentialsException("API Key is invalid");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
