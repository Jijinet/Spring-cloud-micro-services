package com.arfi.springcloudmicroservices.entities;

import com.arfi.springcloudmicroservices.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Date;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class Compte {
    @Id
    private String id;
    private Date createdAt;
    private Double balance;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    private String currency;
}
