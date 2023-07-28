package com.example.bankaccountcqrs.query.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Entity
@Data
@NoArgsConstructor
public class Account {
    @Id
    private String accountId;

    private BigDecimal balance;

    private String status;

    /*public Account(String accountId, BigDecimal balance, String status) {
        this.accountId = accountId;
        this.balance = balance;
        this.status = status;
    }

    public Account() {

    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }*/
}
