package com.turkcell.restapibestpractices.mapper;


import com.turkcell.restapibestpractices.dto.CustomerDto;
import com.turkcell.restapibestpractices.dto.request.CreateCustomerRequest;
import com.turkcell.restapibestpractices.model.Customer;
import org.mapstruct.Mapper;

@Mapper(implementationName = "CustomerMapperImpl" , componentModel = "spring")
public interface CustomerMapper {

    Customer toCustomer(CustomerDto customerDto);

    CustomerDto toCustomerDto(Customer customer);

    Customer toCustomerFromCreateCustomerRequest(CreateCustomerRequest customerRequest);
}
