package com.honeywell.server.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Customer {
    String name;

    String cnp;

    public Customer(String name,  String cnp){
        this.name = name;
        this.cnp = cnp;
    }

}
