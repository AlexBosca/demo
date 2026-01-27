package org.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "whatever")
public class User {
    @Id
    private final Integer id;

    private final String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID: "+ this.id + " - Name: " + this.name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
