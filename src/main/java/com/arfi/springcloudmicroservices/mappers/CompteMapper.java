package com.arfi.springcloudmicroservices.mappers;

import com.arfi.springcloudmicroservices.dto.CompteResponseDTO;
import com.arfi.springcloudmicroservices.entities.Compte;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CompteMapper {

    public CompteResponseDTO fromCompte(Compte compte){
        CompteResponseDTO compteResponseDTO = new CompteResponseDTO();
        BeanUtils.copyProperties(compte,compteResponseDTO);

        return compteResponseDTO;
    }
}
