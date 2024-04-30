package com.example.demo.homework.rent;

public class house {
    private String name;
    private String phone;
    private String address;
    private String rentMoney;
    private boolean status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRentMoney() {
        return rentMoney;
    }

    public void setRentMoney(String rentMoney) {
        this.rentMoney = rentMoney;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
