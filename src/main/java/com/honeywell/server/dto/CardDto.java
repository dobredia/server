package com.honeywell.server.dto;

import com.honeywell.server.entities.CardEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
public class CardDto {

    ContDto Cont;
    int cardNumber;
    int pin;

    @ManyToOne
    private CardEntity  cardEntity;


    public CardDto(int cardNumber, int pin) {
        this.cardNumber = cardNumber;
        this.pin = pin;
    }


}
