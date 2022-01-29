package com.terta.account.dto;

import java.util.Set;

public class CustomerDto {

    private String id;

    private String name;

    private String surname;

    private Set<CustomerAccountDto> account;


    public CustomerDto() {
    }

    public CustomerDto(String id, String name, String surname, Set<CustomerAccountDto> account) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.account = account;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<CustomerAccountDto> getAccount() {
        return account;
    }

    public void setAccount(Set<CustomerAccountDto> account) {
        this.account = account;
    }
}



































