package com.example.demo.od;

import java.util.*;

/**
 * 给定一个数组，编写一个函数来计算它的最大N个数与最小N个数的和。
 * 你需要对数组进行去重。
 */
public class calculateMinMaxSum {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        //使用 treeSet 存储数据,自动排序去重
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < size; i++){
            int tmp = in.nextInt();
            set.add(tmp);
        }
        int count = in.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        if (count*2>set.size()){
            System.out.println("-1");
            return;
        }
        list.addAll(set);
        int res = 0 ;
        for (int i = 0; i < count; i++){
            res += list.get(i);
            res += list.get(list.size()-i-1);
        }
        System.out.println(res);
    }
}
