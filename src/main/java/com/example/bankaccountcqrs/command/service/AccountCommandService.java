package com.example.bankaccountcqrs.command.service;

import com.example.bankaccountcqrs.command.command.CreateAccountCommand;
import com.example.bankaccountcqrs.command.command.DepositMoneyCommand;
import com.example.bankaccountcqrs.command.command.WithdrawMoneyCommand;
import com.example.bankaccountcqrs.command.dto.CreateAccountRequest;
import com.example.bankaccountcqrs.command.dto.DepositRequest;
import com.example.bankaccountcqrs.command.dto.WithdrawRequest;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class AccountCommandService {
    private final CommandGateway commandGateway;

    public AccountCommandService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }


    public CompletableFuture<String> createAccount(CreateAccountRequest createAccountRequest){
        return commandGateway.send(new CreateAccountCommand(
                UUID.randomUUID().toString(),
                createAccountRequest.getStartingBalance()
        ));
    }

    public CompletableFuture<String> depositAccount(DepositRequest depositRequest){
        return commandGateway.send(new DepositMoneyCommand(
                depositRequest.getAccountId(),
                depositRequest.getAmount()
        ));
    }

        public CompletableFuture<String> withdrawAccount(WithdrawRequest withdrawRequest){
        return commandGateway.send(new WithdrawMoneyCommand(
                withdrawRequest.getAccountId(),
                withdrawRequest.getAmount()
        ));
    }
}
