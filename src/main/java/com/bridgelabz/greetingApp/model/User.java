package com.bridgelabz.greetingApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "`user`")
public class User {
    @Id
    private long id;

    public void setId(Long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    // Attributes
    private String firstName;
    private String lastName;

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    //Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + (lastName == null ? "" : lastName);
    }
}
