package com.turkcell.restapibestpractices.service;


import com.turkcell.restapibestpractices.dto.CustomerDto;
import com.turkcell.restapibestpractices.dto.converter.CustomerDtoConverter;
import com.turkcell.restapibestpractices.dto.request.CreateCustomerRequest;
import com.turkcell.restapibestpractices.dto.request.UpdateCustomerRequest;
import com.turkcell.restapibestpractices.exception.CustomerNotFoundException;
import com.turkcell.restapibestpractices.model.enums.City;
import com.turkcell.restapibestpractices.model.Customer;
import com.turkcell.restapibestpractices.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter customerDtoConverter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter customerDtoConverter) {
        this.customerRepository = customerRepository;
        this.customerDtoConverter = customerDtoConverter;
    }

    public CustomerDto createCustomer(CreateCustomerRequest customerRequest){
        Customer customer = new Customer();
        customer.setEmail(customerRequest.getEmail());
        customer.setName(customerRequest.getName());
        customer.setBirthDate(customerRequest.getBirthDate());
        customer.setCity(City.valueOf(customerRequest.getCity().name()));

        customerRepository.save(customer);

        return customerDtoConverter.convert(customer);
    }

    public List<CustomerDto> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();

        List<CustomerDto> customerDtoList = new ArrayList<>();

        for (Customer customer: customerList) {
            customerDtoList.add(customerDtoConverter.convert(customer));
        }

        return customerDtoList;
    }

    @Transactional
    public CustomerDto getCustomerDtoById(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);

        return customerOptional.map(customerDtoConverter::convert)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not exist!"));
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public CustomerDto updateCustomer(Long id, UpdateCustomerRequest customerRequest) {
        Optional<Customer> customerOptional = customerRepository.findById(id);

        customerOptional.ifPresent(customer -> {
            customer.setName(customerRequest.getName());
            customer.setCity(City.valueOf(customerRequest.getCity().name()));
            customer.setBirthDate(customerRequest.getBirthDate());
            customerRepository.save(customer);
        });

        return customerOptional.map(customerDtoConverter::convert)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found!"));
    }

    protected Customer getCustomerById(long id){
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found!"));
    }
}