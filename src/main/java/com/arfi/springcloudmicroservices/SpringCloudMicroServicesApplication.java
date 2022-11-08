package com.arfi.springcloudmicroservices;

import com.arfi.springcloudmicroservices.entities.Compte;
import com.arfi.springcloudmicroservices.enums.AccountType;
import com.arfi.springcloudmicroservices.repositories.CompteRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class SpringCloudMicroServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudMicroServicesApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRespository compteRespository){
        return args -> {
            for (int i = 1; i < 10; i++) {
                Compte compte =Compte.builder()
                        .id(UUID.randomUUID().toString())
                        .type(Math.random()>0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
                        .balance(1000+Math.random()*90000)
                        .createdAt(new Date())
                        .currency("MAD")
                        .build();
                compteRespository.save(compte);
            }
        };
    }
}
