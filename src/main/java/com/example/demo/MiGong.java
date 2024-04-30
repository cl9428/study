package com.example.demo;

import javax.security.auth.login.CredentialNotFoundException;
import java.util.Arrays;

public class MiGong {

    public static void main(String[] args) {

        int a[][] = new int[8][7];
        for (int i = 0;i<a.length;i++){
            a[i][0] = 1;
            a[i][6] = 1;
        }

        for (int i = 0;i<a[0].length;i++){
            a[0][i] = 1;
            a[7][i] = 1;
        }

        a[3][1] = 1;
        a[3][2] = 1;
        a[2][2] = 1;

        System.out.println("开始+++======");
        for (int [] b : a){
            for(int i = 0;i<b.length;i++){
                System.out.print(b[i]+"  ");
            }
            System.out.println();
        }
        System.out.println("======结束");
        findWay(a,1,1);

        for (int [] b : a){
            for(int i = 0;i<b.length;i++){
                System.out.print(b[i]+"  ");
            }
            System.out.println();
        }
    }

    public static boolean findWay(int [][] a,int i,int j){
//        寻路策略 下 右 上 左
        if(a[6][5] == 2){
            return true;
        }else {
            if(a[i][j] == 0){
                a[i][j] =2;
                if(findWay(a,i+1,j)){
                    return true;
                }else if (findWay(a,i,j+1)){
                    return true;
                } else if (findWay(a,i-1,j)) {
                    return true;
                }else if (findWay(a,i,j-1)){
                    return true;
                }
            }else {
                return false;
            }

        }
        return false;
    }

}
