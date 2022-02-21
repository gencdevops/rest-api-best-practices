package com.turkcell.restapibestpractices.dto.request.base;


import com.turkcell.restapibestpractices.model.enums.City;
import com.turkcell.restapibestpractices.model.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseAccountRequest {

    @NotNull(message = "Customer id must not be null")
    private Long customerId;

    @NotNull
    @Min(value = 0, message = "Balance should not be less than 0")
    private Double balance;

    @NotNull(message = "Currency must not be null")
    private Currency currency;

    @NotNull(message = "City must not be null")
    private City city;
}
