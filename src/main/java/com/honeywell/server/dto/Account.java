package com.honeywell.server.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Account {

    Integer id;
    Double balance;
    String iban;
    List<Card> cardList = new ArrayList<>();

    public Account() {
    }

    public Account(Double balance, String iban) {
        this.balance = balance;
        this.iban = iban;
    }

    public Account(Integer id, Double balance, String iban) {
        this.id = id;
        this.balance = balance;
        this.iban = iban;
    }

}
