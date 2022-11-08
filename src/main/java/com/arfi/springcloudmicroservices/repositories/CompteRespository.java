package com.arfi.springcloudmicroservices.repositories;

import com.arfi.springcloudmicroservices.entities.Compte;
import com.arfi.springcloudmicroservices.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Date;
import java.util.List;

@RepositoryRestResource
public interface CompteRespository extends JpaRepository<Compte,String> {

    @RestResource(path = "/byType")
    List<Compte> findByType(@Param("t") AccountType type);


}
