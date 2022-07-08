package com.honeywell.server.dao.entities;


import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "customer")//, uniqueConstraints = {@UniqueConstraint(columnNames = "cnp")}

@NoArgsConstructor
public class CustomerEntity {
    @Id
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String cnp;

    public CustomerEntity(int id, String name, String cnp) {
        this.id = id;
        this.name = name;
        this.cnp = cnp;
    }

    public CustomerEntity(String name, String cnp) {
        this.name = name;
        this.cnp = cnp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }
}