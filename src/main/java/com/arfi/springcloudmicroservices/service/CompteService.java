package com.arfi.springcloudmicroservices.service;

import com.arfi.springcloudmicroservices.dto.CompteRequestDTO;
import com.arfi.springcloudmicroservices.dto.CompteResponseDTO;

public interface CompteService {

    public CompteResponseDTO addCompte(CompteRequestDTO compteRequestDTO);


}
