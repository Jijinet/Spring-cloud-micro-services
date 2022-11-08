package com.arfi.springcloudmicroservices.web;

import com.arfi.springcloudmicroservices.dto.CompteRequestDTO;
import com.arfi.springcloudmicroservices.dto.CompteResponseDTO;
import com.arfi.springcloudmicroservices.entities.Compte;
import com.arfi.springcloudmicroservices.mappers.CompteMapper;
import com.arfi.springcloudmicroservices.repositories.CompteRespository;
import com.arfi.springcloudmicroservices.service.CompteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CompteRestController {

    @Autowired
    private CompteRespository compteRespository;
    @Autowired
    private CompteService compteService;
    @Autowired
    private CompteMapper compteMapper;

    @GetMapping("/comptes")
    public List<Compte> comptes(){

        return compteRespository.findAll();
    }

    @GetMapping("/comptes/{id}")
    public Compte compte(@PathVariable String id){

        return compteRespository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Account %s not found", id)));
    }

    @PostMapping("/comptes")
    public CompteResponseDTO save(@RequestBody CompteRequestDTO compteRequestDTO){

        return compteService.addCompte(compteRequestDTO);
    }

    @PutMapping("comptes/{id}")
    public Compte update(@PathVariable String id,@RequestBody Compte compte){
        Compte bankCompte=compteRespository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Account %s not found", id)));
        if(compte.getBalance()!=null) bankCompte.setBalance(compte.getBalance());
        if(compte.getCreatedAt()!=null) bankCompte.setCreatedAt(new Date());
        if(compte.getCurrency()!=null) bankCompte.setCurrency(compte.getCurrency());
        if(compte.getType()!=null) bankCompte.setType(compte.getType());

        return compteRespository.save(bankCompte);
    }

    @DeleteMapping("/comtpes/{id}")
    public void delete(@PathVariable String id){
         compteRespository.deleteById(id);
    }
}
