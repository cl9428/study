package com.example.demo.sort;

import java.util.Arrays;
import java.util.Collection;

public class QuickSort {

    public static void main(String[] args) {

        int[] num = new int[]{-9,2,2,3,3,0,9,4,3};
        System.out.println(Arrays.toString(num));
        quickSort(num,0,num.length-1);
        System.out.println(Arrays.toString(num));
    }

    public static void quickSort(int[] num,int left,int right){

        int l = left;
        int r = right;
        if(l>r){
            return;
        }
        int middle = num[(left + right)/2];
        int tmp = 0;

        while (l<r){

            while (num[l] < middle && l < r ){
                l++;
            }
            while(num[r] > middle&& l < r ){
                r--;
            }
            if (l >= r){
                break;
            }

            if (l < r) {
                tmp = num[l];
                num[l] = num[r];
                num[r] = tmp;
            }
            if (num[l] == middle) {
                r--;
            }
            if (num[r] == middle) {
                l++;
            }
        }
        if(l == r){
            l++;
            r++;
        }
        if(left<r){
            quickSort(num,left,r);
        }
        if (l<right){
            quickSort(num,l,right);
        }

    }
}
