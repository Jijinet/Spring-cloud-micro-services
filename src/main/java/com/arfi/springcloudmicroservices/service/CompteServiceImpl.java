package com.arfi.springcloudmicroservices.service;

import com.arfi.springcloudmicroservices.dto.CompteRequestDTO;
import com.arfi.springcloudmicroservices.dto.CompteResponseDTO;
import com.arfi.springcloudmicroservices.entities.Compte;
import com.arfi.springcloudmicroservices.mappers.CompteMapper;
import com.arfi.springcloudmicroservices.repositories.CompteRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;


@Service
@Transactional
public class CompteServiceImpl implements CompteService {
    @Autowired
    CompteRespository compteRespository;
    @Autowired
    private CompteMapper compteMapper;

    @Override
    public CompteResponseDTO addCompte(CompteRequestDTO compteRequestDTO) {

        Compte compte = Compte.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .type(compteRequestDTO.getType())
                .balance(compteRequestDTO.getBalance())
                .currency(compteRequestDTO.getCurrency())
                .build();

        Compte savedCompte = compteRespository.save(compte);

        CompteResponseDTO compteResponseDTO = compteMapper.fromCompte(savedCompte);
        return compteResponseDTO;
    }
}
