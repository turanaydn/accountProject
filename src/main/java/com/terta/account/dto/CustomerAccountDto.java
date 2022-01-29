package com.terta.account.dto;

import com.terta.account.dto.TransactionDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public class CustomerAccountDto {

    private String id;

    private final BigDecimal balance = BigDecimal.ZERO;

    private LocalDateTime creationsDate;

    private Set<TransactionDto> transactions;

    public CustomerAccountDto() {
    }

    public CustomerAccountDto(String id, LocalDateTime creationsDate, Set<TransactionDto> transactions) {
        this.id = id;
        this.creationsDate = creationsDate;
        this.transactions = transactions;
    }

    public <T, R> CustomerAccountDto(Object requireNonNull, BigDecimal balance, R collect, LocalDateTime creationDate) {
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

    public LocalDateTime getCreationsDate() {
        return creationsDate;
    }

    public void setCreationsDate(LocalDateTime creationsDate) {
        this.creationsDate = creationsDate;
    }

    public Set<TransactionDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<TransactionDto> transactions) {
        this.transactions = transactions;
    }
}























