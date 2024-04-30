package com.example.demo;

public class hanriTest {

    public static void main(String[] args) {
        move(3,'A','B','C');
    }

//    汉诺塔 移动
    static void move(int num,char a,char b,char c){
//        1.只有一个盘
        if(num == 1){
            System.out.println(a +"->" +c);
        }else {
//            两个  借助 b 将 a 的盘 移动到 c
//            先把 盘放到 b
            move(num -1,a ,c,b);
            System.out.println(a +"->"+c);
//            再把 盘 从 b 放到 c
            move(num - 1,b,a,c);
        }

    }
}
