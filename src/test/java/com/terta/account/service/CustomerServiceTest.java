package com.terta.account.service;

import com.terta.account.dto.CustomerDto;
import com.terta.account.dto.converter.CustomerDtoConverter;
import com.terta.account.model.Customer;
import com.terta.account.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class CustomerServiceTest {

    private CustomerService customerService;

    private CustomerRepository customerRepository;

    private CustomerDtoConverter customerDtoConverter;


    @BeforeEach
    public void setUp() {
        customerRepository = mock(CustomerRepository.class);
        customerDtoConverter = mock (CustomerDtoConverter.class);
        customerService = new CustomerService (customerRepository, customerDtoConverter);
    }

    @Test
    public void testFindByCustomerId_whenCustomerIdExists_shouldReturnCustomer() {
        Customer customer = null;

        assert false;
        Mockito.when (customerRepository.findById ("id")).thenReturn (Optional.of (customer));

        CustomerDto result = customerService.getCustomerById ("id");

        assertEquals (result, customer);
    }

}
