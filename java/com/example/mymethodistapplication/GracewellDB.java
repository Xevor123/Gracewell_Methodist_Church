package com.example.mymethodistapplication;

public class GracewellDB {
    String email;
    String password;
    String name;
    String surname;
    String cellNum;

    public GracewellDB(String email, String password, String name, String surname, String cellNum) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.cellNum = cellNum;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCellNum() {
        return cellNum;
    }
}
