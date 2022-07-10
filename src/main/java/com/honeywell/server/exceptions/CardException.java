package com.honeywell.server.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardException extends Exception {
    String errorMessage;

    String errorCode;

    public CardException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public CardException(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorMessage = errorCode;
    }
}
