package com.turkcell.restapibestpractices.dto.request;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WithdrawMoneyRequest {
    private long id;
    private double amount;
}
