package com.terta.account.dto.converter;


import com.terta.account.dto.AccountCustomerDto;
import com.terta.account.dto.CustomerDto;
import com.terta.account.model.Customer;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter {

    private final CustomerAccountDtoConverter customerAccountDtoConverter;

    public CustomerDtoConverter(CustomerAccountDtoConverter converter) {
        this.customerAccountDtoConverter = converter;
    }

    public AccountCustomerDto convertToAccountCustomer(Optional<Customer> from) {
        return from.map (f -> new AccountCustomerDto (f.getId (), f.getName (), f.getSurname ())).orElse (null);
    }


    public CustomerDto convertToCustomerDto(Customer from) {
        return new CustomerDto (
                from.getId (),
                from.getName (),
                from.getSurname (),
                from.getAccount ().stream ().map (customerAccountDtoConverter::convert)
                .collect (Collectors.toSet ()));
    }



}
