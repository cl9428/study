package com.example.demo.design;

public class singleton {
    public static void main(String[] args) {
        Cat.getInstance(20);
    }

}

class Cat{

    private static String name;

    private static Cat cat;


    private Cat(String name){
        System.out.println("Cat 被调用");
        this.name = name;
    }


    public static Cat getInstance(int n){
        if (cat == null){
            cat = new Cat("cat");
        }
        System.out.println("斐波那契数第"+n+"个值是"+cat.cc(n));
        return cat;
    }


    public int cc(int n){
        new cat(){
            @Override
            public int run(int n){
                if(n>1){
                    if (n == 1|| n==2){
                        return 1;
                    }else {
                        return run(n-1)+run(n-2);
                    }
                }
                return n;
            }
        }.run(n);
        if(n>1){
            if (n == 1|| n==2){
                return 1;
            }else {
                return cc(n-1)+cc(n-2);
            }
        }
        return n;
    }

    class cat{
        public int run(int n){
            return n;
        }
    }
}