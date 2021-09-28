package ru.tka.spring.parser.parser.util;

public class User {
    private String name;
    private String middleName;
    private String surname;

    public User() {
    }

    public User(String name, String middleName, String surname) {
        this.name = name;
        this.middleName = middleName;
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "User: name = " + name + ", middleName = " + middleName + ", surname = " + surname;
    }
}
