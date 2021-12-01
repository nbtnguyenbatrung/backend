package com.huce.manege.serviceimpl;

import com.huce.manege.entity.ApiKeyEntity;

public interface ApiKeyServiceimpl {
       ApiKeyEntity getusername(String username);
       ApiKeyEntity saveapikey(ApiKeyEntity apiKeyEntity);
}
