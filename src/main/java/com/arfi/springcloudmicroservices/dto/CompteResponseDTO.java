package com.arfi.springcloudmicroservices.dto;

import com.arfi.springcloudmicroservices.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CompteResponseDTO {

    private String id;
    private Date createdAt;
    private Double balance;
    private AccountType type;
    private String currency;
}
