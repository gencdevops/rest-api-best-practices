package com.turkcell.restapibestpractices.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.turkcell.restapibestpractices.model.enums.Currency;
import lombok.*;



@Getter
@Setter
@Builder
public class AccountDto {


    private long id;

    private Long customerId;
    private Double balance;
    private Currency currency;
}