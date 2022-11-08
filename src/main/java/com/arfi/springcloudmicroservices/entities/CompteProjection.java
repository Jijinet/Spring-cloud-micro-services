package com.arfi.springcloudmicroservices.entities;

import com.arfi.springcloudmicroservices.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Compte.class,name = "p1")
public interface CompteProjection {
    public String getId();
    public AccountType getType();
}
