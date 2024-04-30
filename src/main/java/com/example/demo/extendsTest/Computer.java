package com.example.demo.extendsTest;

public class Computer {
    private String cpu;
    private int disk;

    Computer(String cpu,int disk){
        this.cpu = cpu;
        this.disk = disk;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getDisk() {
        return disk;
    }

    public void setDisk(int disk) {
        this.disk = disk;
    }

    public void getPrintInfo(){
        System.out.println("cpu="+cpu+" disk="+disk);
    }
}
