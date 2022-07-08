package com.honeywell.server.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private String name;
    private String cnp;

    private ArrayList<ContDto> contList = new ArrayList<>();

    public UserDto(String name, String cnp){
        this.name = name;
        this.cnp = cnp;
    }
}
