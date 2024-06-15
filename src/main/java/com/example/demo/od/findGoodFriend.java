package com.example.demo.od;

import java.util.Scanner;

/**
 * 在学校中，N个小朋友站成一队， 第i个小朋友的身高为height[i]，
 * 第i个小朋友可以看到的第一个比自己身高更高的小朋友j，那么j是i的好朋友(要求j > i)。
 * 请重新生成一个列表，对应位置的输出是每个小朋友的好朋友位置，
 * 如果没有看到好朋友，请在该位置用0代替。小朋友人数范围是 [0, 40000]。
 *
 * i<j    height[i]<height[j]
 * 好朋友  的位置 ==== i  j
 */
public class findGoodFriend {
    /**
     * 输入：
     * 第一行N，N表示有N个小朋友
     * 第二行输入N个小朋友的身高
     * 示例：
     * 输入
     * 2
     * 100,95
     * 输出：
     * 0，0
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++){
            height[i] = scanner.nextInt();
        }
//        int[] height = { 1, 2, 3, 4, 5 };
        int[] res = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            int j = i + 1;
            while (j < height.length) {
                if (height[j] > height[i]) {
                    res[i] = j + 1;
                    break;
                }
               j++;
           }
       }
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
   }

}
