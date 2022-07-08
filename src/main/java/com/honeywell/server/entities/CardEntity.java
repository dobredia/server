package com.honeywell.server.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="card")
@NoArgsConstructor
public class CardEntity {
    @Id
    private int id;

    @Column(nullable = false)
    private String cardNumber;

    @Column(nullable = false)
    private int pin;

    @ManyToOne
    private ContEntity cont;

    public CardEntity(int id, String number, int pin ){
        this.id = id;
        this.cardNumber = number;
        this.pin = pin;
    }

    public CardEntity( String number, int pin ){
        this.cardNumber = number;
        this.pin = pin;
    }

    @ManyToOne(optional = false)
    private ContEntity contEntities;

    public ContEntity getContEntities() {
        return contEntities;
    }

    public void setContEntities(ContEntity contEntities) {
        this.contEntities = contEntities;
    }
}
