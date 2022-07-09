package com.honeywell.server.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardException extends Exception{
    String errorMessage;

    public CardException(String errorMessage){
        this.errorMessage = errorMessage;
    }
}
