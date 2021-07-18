package com.example.orderapp.Database;

public class Data {
    private String email, password, name, telephonenumber, address;
    public Data(String email, String password, String name, String telephonenumber, String address) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.telephonenumber = telephonenumber;
        this.address = address;
    }

//    public Data(String email, String password) {
//        this.email = email;
//        this.password = password;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephonenumber() {
        return telephonenumber;
    }

    public void setTelephonenumber(String telephonenumber) {
        this.telephonenumber = telephonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
