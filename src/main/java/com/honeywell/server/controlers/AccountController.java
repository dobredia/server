package com.honeywell.server.controlers;

import com.honeywell.server.dto.Account;
import com.honeywell.server.dto.Card;
import com.honeywell.server.exceptions.AccountException;
import com.honeywell.server.exceptions.Constants;
import com.honeywell.server.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static com.honeywell.server.exceptions.Constants.ACCOUNT_NOT_FOUND;


@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping(path={"/getAccount/{accountId}"})
    public Account getAccount(@PathVariable Integer accountId){
        try {
            return accountService.getAccount(accountId);
        } catch (AccountException exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, exc.getErrorMessage(), exc);
        }
    }

    @PostMapping(path = {"/account/{Id}/updateBalance"},params = {"cashAmount"})
    public Account updateBalanceAccount(@PathVariable Integer Id, @RequestParam Double cashAmount){
        try{
            return accountService.updateBalanceAccount(Id,cashAmount);
        }catch (AccountException exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, exc.getErrorMessage(), exc);
        }
    }

}
