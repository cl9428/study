package com.example.demo.arrys;

import java.util.Arrays;

public class HomeWork04 {
    public static void main(String[] args) {

        int [] a = {10,15,45,79};
        int b = 344;
        int [] c = new int[a.length+1];
        for (int i=0,j=0;i<c.length;i++){
            if(j >= a.length){
                break;
            }
            if (a[j] < b){
                c[i] = a[i];
                j++;
            }else if(i == j){
                c[i] = b;
            }else {
                c[i] = a[j++];
            }

        }
        if(c[c.length-1]==0){
            c[c.length-1] = b;
        }
        System.out.println(Arrays.toString(c));
    }
}
