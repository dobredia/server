package com.honeywell.server.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ContDto {

    UserDto userDto;
    double balance;
    String iban;

    ArrayList<CardDto> cardDtoList = new ArrayList<>();

    public ContDto(UserDto userDto, double balance, String iban) {
        this.userDto = userDto;
        this.balance = balance;
        this.iban = iban;
    }
}
