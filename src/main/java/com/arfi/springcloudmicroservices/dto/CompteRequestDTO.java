package com.arfi.springcloudmicroservices.dto;

import com.arfi.springcloudmicroservices.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class CompteRequestDTO {

    private Double balance;
    private AccountType type;
    private String currency;
}
