package com.honeywell.server.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="accounts")
@Getter @Setter
public class AccountEntity {
    @Id
    private Integer id;

    @Column(name="balance", nullable = false)
    private Double balance;

    @Column(name = "iban", nullable = false)
    private String iban;

    @OneToMany(mappedBy= "account", cascade = CascadeType.ALL)
    private List<CardEntity> cards = new ArrayList<>();

    public AccountEntity(){
    }

    public AccountEntity(Double balance, String iban) {
        this.balance = balance;
        this.iban = iban;
    }

    public AccountEntity(Integer id, Double balance, String iban) {
        this.id = id;
        this.balance = balance;
        this.iban = iban;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", iban='" + iban + '\'' +
                ", cards=" + cards +
                '}';
    }
}
