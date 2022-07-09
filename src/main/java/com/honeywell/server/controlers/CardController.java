package com.honeywell.server.controlers;

import com.honeywell.server.dto.Card;
import com.honeywell.server.exceptions.CardException;
import com.honeywell.server.exceptions.Constants;
import com.honeywell.server.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CardController {
    @Autowired
    private CardService cardService;

   @GetMapping(path={"/getBalance/{cardNumber}"})
    public Card getBalance(@PathVariable String cardNumber){
       try {
           return cardService.getBalance(cardNumber);
       } catch (CardException exc) {
           throw new ResponseStatusException(
                   HttpStatus.NOT_FOUND, exc.getMessage(), exc);
       }
   }

    @GetMapping(path={"/getPin/{cardNumber}"})
    public Card getPin(@PathVariable String cardNumber){
        try {
            return cardService.getPin(cardNumber);
        } catch (CardException exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, exc.getMessage(), exc);
        }
    }

    @PostMapping(path = {"/card/{cardNumber}/updatePin"},params = {"newCardPin"})
    public Card changeCardPin(@PathVariable String cardNumber, @RequestParam String newCardPin){
       try{
           return cardService.changeCardPin(cardNumber, newCardPin);
       }catch (CardException exc) {
           throw new ResponseStatusException(
                   HttpStatus.NOT_FOUND, exc.getMessage(), exc);
       }
    }

}