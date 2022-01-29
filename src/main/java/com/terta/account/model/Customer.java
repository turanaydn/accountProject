package com.terta.account.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue(generator = "UUID")
   // @GenericGenerator (name = "UUID", strategy = "org.hibernate.id.UUIGenerator")
    private String id;

    private String name;

    private String surname;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<Account> account;


    public Customer() {
    }

    public Customer(String id, String name, String surname, Set<Account> account) {
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

    public Set<Account> getAccount() {
        return account;
    }

    public void setAccount(Set<Account> account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals (getId (), customer.getId ()) && Objects.equals (getName (), customer.getName ()) && Objects.equals (getSurname (), customer.getSurname ()) && Objects.equals (getAccount (), customer.getAccount ());
    }

    @Override
    public int hashCode() {
        return Objects.hash (getId (), getName (), getSurname (), getAccount ());
    }
}

























