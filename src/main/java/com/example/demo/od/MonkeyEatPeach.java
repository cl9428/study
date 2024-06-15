package com.example.demo.od;

import java.util.Arrays;

/**
 * 孙悟空喜欢吃蟠桃，一天他乘守卫蟠桃园的天兵天将离开了而偷偷的来到王母娘娘的蟠桃园偷吃蟠桃。
 * 已知蟠桃园有 N 棵蟠桃树，第 i 棵蟠桃树上有 N[i]（大于 0）个蟠桃，天兵天将将在 H（不小于蟠桃树棵数）小时后回来。
 * 孙悟空可以决定他吃蟠桃的速度 K（单位：个/小时），每个小时他会选择一颗蟠桃树，从中吃掉 K 个蟠桃，
 * 如果这棵树上的蟠桃数小于 K，他将吃掉这棵树上所有蟠桃，然后这一小时内不再吃其余蟠桃树上的蟠桃。
 * 孙悟空喜欢慢慢吃，但仍想在天兵天将回来前将所有蟠桃吃完。
 */
public class MonkeyEatPeach {


    public static void main(String[] args) {

        int[] peach = {3,11,6,7};
        peach = Arrays.stream(peach).sorted().toArray();
        int max = peach[peach.length-1];
        System.out.println(max);
        for (int i = 1; i <= max; i++){
            if ( getMaxPeach(peach, i, 8)){
                System.out.println("最慢"+(i));
                break;
            }else {
            }
        }
    }

    public static boolean getMaxPeach(int[] peach, int k, int h) {

        int sum = 0;
        sum = Arrays.stream(peach).sum();
        if ( k * h >= sum ){
            return true;
        }
        return false;
   }
}
