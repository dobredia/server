package com.honeywell.server.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Card {
    String cardNumber;
    String pin;
    Account accountInformation;

    public Card(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Card(String cardNumber, String pin, Account accountInformation) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.accountInformation = accountInformation;
    }

    public Card(String cardNumber, String pin) {
        this.cardNumber = cardNumber;
        this.pin = pin;
    }
}
