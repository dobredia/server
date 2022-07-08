package com.honeywell.server.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Getter @Setter
public class UserEntity {
    @Id
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String cnp;

    @OneToMany(mappedBy = "user")
    private List<ContEntity> contList = new ArrayList<>();

    public UserEntity(){}

    public UserEntity(int id, String name, String cnp) {
        this.id = id;
        this.name = name;
        this.cnp = cnp;
    }

    public UserEntity(String name, String cnp) {
        this.name = name;
        this.cnp = cnp;
    }

}