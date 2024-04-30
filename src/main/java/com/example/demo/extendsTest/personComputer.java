package com.example.demo.extendsTest;

public class personComputer extends Computer{
    private String brand;

    public personComputer(String cpu, int disk, String brand) {
        super(cpu, disk);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void printInfo(){
        getPrintInfo();System.out.print(" brand="+brand);
    }
}
