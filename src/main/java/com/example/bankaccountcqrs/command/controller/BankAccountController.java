package com.example.bankaccountcqrs.command.controller;

import com.example.bankaccountcqrs.command.command.CreateAccountCommand;
import com.example.bankaccountcqrs.command.command.WithdrawMoneyCommand;
import com.example.bankaccountcqrs.command.dto.CreateAccountRequest;
import com.example.bankaccountcqrs.command.dto.DepositRequest;
import com.example.bankaccountcqrs.command.dto.WithdrawRequest;
import com.example.bankaccountcqrs.command.service.AccountCommandService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/bank-account")
public class BankAccountController {

    private final AccountCommandService accountCommandService;

    public BankAccountController(AccountCommandService accountCommandService) {
        this.accountCommandService = accountCommandService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<String> createAccount(@RequestBody CreateAccountRequest request){
        try {
            CompletableFuture<String> response =
                    accountCommandService.createAccount(request);

            return new ResponseEntity<>(response.get(),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("An Error Occurred.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value="/deposit")
    public ResponseEntity<String> deposit(@RequestBody DepositRequest request){
        try {
            CompletableFuture<String> response =
                    accountCommandService.depositAccount(request);

            return new ResponseEntity<>("Amount credited",HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>("An Error Occurred.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value="/withdraw")
    public ResponseEntity<String> withdraw(@RequestBody WithdrawRequest request){
        try {
            CompletableFuture<String> response =
                    accountCommandService.withdrawAccount(request);
            return new ResponseEntity<>("Amount debited",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("An Error Occurred.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
