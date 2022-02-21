package com.turkcell.restapibestpractices.dto;


import com.turkcell.restapibestpractices.model.enums.City;
import com.turkcell.restapibestpractices.model.enums.Currency;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class AccountDto implements Serializable {

    private long id;
    private Long customerId;
    private Double balance;
    private Currency currency;
}