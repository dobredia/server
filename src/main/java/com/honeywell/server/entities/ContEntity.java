package com.honeywell.server.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="cont")
@Getter @Setter
public class ContEntity {
    @Id
    private int id;

    @Column(name="balance", nullable = false)
    private double balance;

    @Column(name = "iban", nullable = false)
    private String iban;

    @ManyToOne
    private UserEntity user;

    @OneToMany(mappedBy= "cont")
    private List<CardEntity> cards = new ArrayList<>();

    public ContEntity(){
    }

    public ContEntity(int id, double balance, String iban) {
        this.id = id;
        this.balance = balance;
        this.iban = iban;
    }

    public ContEntity(double balance, String iban) {
        this.balance = balance;
        this.iban = iban;
    }
}
