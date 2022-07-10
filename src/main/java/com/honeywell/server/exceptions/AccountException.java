package com.honeywell.server.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountException extends Exception {
    String errorMessage;

    public AccountException(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
