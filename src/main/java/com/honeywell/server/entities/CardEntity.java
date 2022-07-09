package com.honeywell.server.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="cards")
@Getter @Setter
public class CardEntity {
    @Id
    private Integer id;
    @Column(nullable = false)
    private String cardNumber;
    @Column(nullable = false)
    private String pin;

    @ManyToOne
    @JoinColumn(name="account_id")
    private AccountEntity account;
    public CardEntity(){}

    public CardEntity(String cardNumber, String pin ){
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    public CardEntity(Integer id, String cardNumber, String pin ){
        this.id = id;
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", pin='" + pin + '\'' +
                '}';
    }
}