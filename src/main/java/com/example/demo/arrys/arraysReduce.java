package com.example.demo.arrys;

import java.util.Arrays;
import java.util.Scanner;

public class arraysReduce {
    public static void main(String[] args) {
        int [] a = {1,2,3,4,5};
        System.out.println("数组元素"+ a);
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("数组元素"+ Arrays.toString(a));

            if(a.length>1) {
                int [] b = new int[a.length - 1];
                for (int c = 0; c < b.length; c++) {
                    b[c] = a[c];
                }
                System.out.println("删减后的 数组元素"+ Arrays.toString(b));
                a = b;
            }else {
                System.out.println("只剩一个元素了");
                return;
            }
            System.out.println("是否继续（y/n）");
            if (scanner.next().charAt(0) == 'n') {
                break;
            }
        }while(true);
    }
}
