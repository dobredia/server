package com.honeywell.server.services;

import com.honeywell.server.dto.Account;
import com.honeywell.server.dto.Card;
import com.honeywell.server.entities.AccountEntity;
import com.honeywell.server.exceptions.AccountException;
import com.honeywell.server.repository.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


import static com.honeywell.server.exceptions.Constants.*;

@Service
public class AccountService {
    @Autowired
    private AccountDAO accountDAO;

    public Account getAccount(Integer accountId) throws AccountException {
        try {
            AccountEntity accountEntity = accountDAO.findById(accountId).get();
            Account account = new Account(accountEntity.getBalance(), accountEntity.getIban());
            List<Card> cards = accountEntity.getCards()
                    .stream().map(a -> new Card(a.getCardNumber(), a.getPin()))
                    .collect(Collectors.toList());
            account.setCardList(cards);
            return account;
        }catch (NoSuchElementException exec) {
            throw new AccountException(ACCOUNT_NOT_FOUND);
        }
    }

    public Account updateBalanceAccount(Integer accountId, Double cashAmount) throws AccountException{
        try {
            AccountEntity accountEntity = accountDAO.findById(accountId).get();
            if (accountEntity.getBalance()+cashAmount<0){
                throw new AccountException(INSUFFICIENT_FOUNDS);
            }
            accountEntity.setBalance(accountEntity.getBalance()+cashAmount);
            accountDAO.saveAndFlush(accountEntity);
            Account account = new Account(accountEntity.getBalance(), accountEntity.getIban());
            return account;
        }catch (NoSuchElementException exec) {
            throw new AccountException(ACCOUNT_NOT_FOUND);
        }
    }
}
