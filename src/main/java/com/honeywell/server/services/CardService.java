package com.honeywell.server.services;

import com.honeywell.server.dto.Account;
import com.honeywell.server.dto.Card;
import com.honeywell.server.entities.CardEntity;
import com.honeywell.server.exceptions.CardException;
import com.honeywell.server.repository.CardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import static com.honeywell.server.exceptions.Constants.*;

@Service
public class CardService {
    @Autowired
    private CardDAO cardDao;

    public Card getBalance(String cardNumber) throws CardException {
        try{
            CardEntity cardEntity = cardDao.findByCardNumber(cardNumber).get();
            Card card = new Card(cardEntity.getCardNumber(),cardEntity.getPin());
            Account account = new Account(cardEntity.getAccount().getBalance(), cardEntity.getAccount().getIban());
            card.setAccountInformation(account);
            return card;
        }catch(NoSuchElementException exe){
            throw new CardException(CARD_NOT_FOUND);
        }
    }

    public Card getPin(String cardNumber) throws CardException {
        try{
            CardEntity cardEntity = cardDao.findByCardNumber(cardNumber).get();
            Card card = new Card(cardEntity.getCardNumber(),cardEntity.getPin());
            return card;
        }catch(NoSuchElementException exe){
            throw new CardException(CARD_NOT_FOUND);
        }
    }

    public Card changeCardPin(String cardNumber, String newCardPin) throws CardException {
        try{
            CardEntity cardEntity = cardDao.findByCardNumber(cardNumber).get();
            cardEntity.se
            return null;
        }catch(NoSuchElementException exe){
            throw new CardException(CARD_NOT_FOUND);
        }
    }
}