package com.example.demo;

public class test {
    public static void main(String[] args) {
        T t = new T();
        System.out.println(t.cl("cl",23.0,888.0));
    }
}

class T{
    String cl(String name,double... nums){
        double count = 0;
        for (double b : nums){
            count += b;
        }
        return name +"you "+nums.length+"menke fenshuwei"+count;
    }

}
