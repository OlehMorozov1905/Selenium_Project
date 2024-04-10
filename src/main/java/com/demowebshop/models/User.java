package com.demowebshop.models;

public class User {
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    public User setEmail(String email) {
        this.email = email;
        return this;
    }
    public User setPassword(String password) {
        this.password = password;
        return this;
    }
    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
}
