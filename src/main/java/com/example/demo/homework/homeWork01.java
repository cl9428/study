package com.example.demo.homework;

import java.util.Arrays;

public class homeWork01 {
    public static void main(String[] args) {

        Person[] people = new Person[5];
        people[0] = new Person("cl2",23);
        people[1] = new Person("cl5",26);
        people[2] = new Person("cl4",25);
        people[3] = new Person("cl3",24);
        people[4] = new Person("cl1",22);

        int count = 0;
        Person tmp = null;
        for(int i=0;i<people.length-1;i++){
            for(int j=0;j<people.length-1-i;j++){
                if(people[j].getAge() > people[j+1].getAge()){
                    tmp = people[j];
                    people[j] = people[j+1];
                    people[j+1] = tmp;
                    count ++;
                }
            }
        }

        System.out.println(Arrays.toString(people));
        System.out.println(count);
    }
}

class Person{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}