package com.terta.account.service;

import com.terta.account.dto.AccountDto;
import com.terta.account.dto.converter.AccountDtoConverter;
import com.terta.account.dto.request.CreateAccountRequest;
import com.terta.account.model.Account;
import com.terta.account.model.Customer;
import com.terta.account.model.Transaction;
import com.terta.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    private final CustomerService customerService;

    private final AccountDtoConverter accountDtoConverter;

    public AccountService(AccountRepository accountRepository, CustomerService customerService,
                          AccountDtoConverter accountDtoConverter) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.accountDtoConverter = accountDtoConverter;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest) {
        Customer customer = customerService.findCustomerById (createAccountRequest.getCustomerId ());

        Account account = new Account (customer,
                createAccountRequest.getInitialCredit (),
                LocalDateTime.now ());

        if (createAccountRequest.getInitialCredit ().compareTo (BigDecimal.ZERO) > 0) {
            Transaction transaction = new Transaction (createAccountRequest.getInitialCredit (), account);
            account.getTransaction ().add (transaction);
        }

        //Transaction i hic kaybetmeden direct account u set etsek bile jpa unu kaydeder zaten
        return accountDtoConverter.convert (accountRepository.save (account));


    }
}
