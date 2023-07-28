package com.example.bankaccountcqrs.command.command;

import lombok.Data;

import java.math.BigDecimal;

public class WithdrawMoneyCommand extends BaseCommand<String>{

    private BigDecimal amount;


    public WithdrawMoneyCommand(String id, BigDecimal amount) {
        super(id);
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
