package com.terta.account.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
public class Account {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator (name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id = "";

    private final BigDecimal balance = BigDecimal.ZERO;

    private LocalDateTime creationDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Transaction> transaction;


    public Account() {
    }

    public Account(String id, LocalDateTime creationDate, Customer  customer, Set<Transaction> transaction) {
        this.id = id;
        this.creationDate = creationDate;
        this.customer = customer;
        this.transaction = transaction;
    }

    public Account(Customer customer, BigDecimal initialCredit, LocalDateTime now) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Set<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(Set<Transaction> transaction) {
        this.transaction = transaction;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", balance=" + balance +
                ", creationDate=" + creationDate +
                ", customer=" + customer +
                ", transaction=" + transaction +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals (getId (), account.getId ()) && Objects.equals (getBalance (), account.getBalance ()) && Objects.equals (getCreationDate (), account.getCreationDate ()) && Objects.equals (getCustomer (), account.getCustomer ()) && Objects.equals (getTransaction (), account.getTransaction ());
    }

    @Override
    public int hashCode() {
        return Objects.hash (getId (), getBalance (), getCreationDate (), getCustomer (), getTransaction ());
    }
}































