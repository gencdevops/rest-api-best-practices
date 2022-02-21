package com.turkcell.restapibestpractices.dto.converter;

import com.turkcell.restapibestpractices.dto.CityDto;
import com.turkcell.restapibestpractices.dto.CustomerDto;
import com.turkcell.restapibestpractices.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoConverter {

    public CustomerDto convert(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setCity(CityDto.valueOf(customer.getCity().name()));
        customerDto.setName(customer.getName());
        customerDto.setBirthDate(customer.getBirthDate());
        customerDto.setEmail(customer.getEmail());

        return customerDto;
    }
}
