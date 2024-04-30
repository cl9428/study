package com.example.demo.homework.rent;

import java.util.Scanner;

public class HouseSystem {

    house[] houses = new  house[100];
    public void mainE(){
        System.out.println("----------房屋出租系统------------");
        System.out.println("\t\t\t\t1。新增房源");
        System.out.println("\t\t\t\t2。查找房屋");
        System.out.println("\t\t\t\t3。删除房屋");
        System.out.println("\t\t\t\t4。修改房屋信息");
        System.out.println("\t\t\t\t5。房屋列表");
        System.out.println("\t\t\t\t6。退出");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");
        String input = scanner.next();
        switch (input){
            case "1":
                add();
            case "2":
                delete();
            case "3":
                select();
            case "4":
                update();
            case "5":
                list();
            case "6":
                exit();
            default:
                System.out.println("输入有误会！！！");
        }
    }

    public void add(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------添加房屋----------");
        int length = houses.length;
        String name  = scanner.next();
        System.out.print("姓名");

        System.out.print("电话");
        System.out.print("地址");
        System.out.print("月租");
        System.out.print("状态（已出租/未出租）");
    }
    public void delete(){

    }
    public void select(){

    }
    public void update(){

    }
    public void list(){

    }
    public void exit(){

    }

}
