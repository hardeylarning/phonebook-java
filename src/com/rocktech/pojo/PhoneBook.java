package com.rocktech.pojo;

import java.time.LocalDate;

public class PhoneBook {
    private String name;
    private String email;
    private LocalDate dateCreated;

    public PhoneBook(String name, String email, LocalDate dateCreated) {
        this.name = name;
        this.email = email;
        this.dateCreated = dateCreated;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "Name: '" + name + '\'' +
                ", Email: '" + email + '\'' +
                ", Date Created: " + dateCreated +
                '}';
    }
}
