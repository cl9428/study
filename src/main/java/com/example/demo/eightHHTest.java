package com.example.demo;

import java.util.Arrays;

public class eightHHTest {
    public static void main(String[] args) {
        int[] res = new int[8];
        eightHH eightH = new eightHH();
        eightH.jie(res,0);

    }

}


class eightHH{
    boolean check(int[] res,int i){
        for (int a=0;a<i;a++){
            if(res[i] == res[a] || Math.abs(a-i)==Math.abs(res[a]-res[i])){
                return false;
            }
        }
        return true;
    }
    int count =0;
    public int jie(int[] res,int i){
        if(i==8){
            System.out.println(Arrays.toString(res));
            count++;
        }else {

            for (int a=0;a<res.length;a++){
                res[i] = a;
                if(check(res,i)){
                    jie(res,i+1);
                }

            }

        }
        return count;
    }

}
