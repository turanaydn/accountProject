package com.terta.account.service;

import com.terta.account.dto.CustomerDto;
import com.terta.account.dto.converter.CustomerAccountDtoConverter;
import com.terta.account.dto.converter.CustomerDtoConverter;
import com.terta.account.exception.CustomerNotFoundException;
import com.terta.account.model.Customer;
import com.terta.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerDtoConverter customerDtoConverter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter customerDtoConverter) {
        this.customerRepository = customerRepository;
        this.customerDtoConverter = customerDtoConverter;
    }

    protected Customer findCustomerById(String id) {
        return customerRepository.findById (id).orElseThrow (
                () -> new CustomerNotFoundException ("Customer could not find by id:" + id));
    }

    public CustomerDto getCustomerById(String customerId) {
        return customerDtoConverter.convertToCustomerDto (findCustomerById (customerId));
    }


}












































