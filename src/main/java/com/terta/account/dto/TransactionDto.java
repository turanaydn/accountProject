package com.terta.account.dto;

import com.terta.account.model.Account;
import com.terta.account.utility.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDto {

    private String id;

    private BigDecimal balance;

    private LocalDateTime creationDate;

    private  TransactionType transactionType = TransactionType.INITIAL;


    public TransactionDto() {
    }


    public TransactionDto(String id, TransactionType transactionType, Account account, LocalDateTime transactionDate) {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}



































