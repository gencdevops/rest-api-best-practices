package com.turkcell.restapibestpractices.repository;

import com.turkcell.restapibestpractices.model.Account;
import com.turkcell.restapibestpractices.model.enums.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    //select * from account where balance > $(balance)
    List<Account> findAllByBalanceGreaterThan(Double balance);

    //select * from account where currency=$(currency) and balance < 100
    List<Account> findAllByCurrencyIsAndAndBalanceLessThan(Currency currency, Double balance);

}
