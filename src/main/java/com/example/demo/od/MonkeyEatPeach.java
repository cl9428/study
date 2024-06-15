package com.example.demo.od;

import java.util.Arrays;


public class MonkeyEatPeach {
    /**
     * 孙悟空喜欢吃蟠桃，一天他乘守卫蟠桃园的天兵天将离开了而偷偷的来到王母娘娘的蟠桃园偷吃蟠桃。
     * 已知蟠桃园有 N 棵蟠桃树，第 i 棵蟠桃树上有 N[i]（大于 0）个蟠桃，天兵天将将在 H（不小于蟠桃树棵数）小时后回来。
     * 孙悟空可以决定他吃蟠桃的速度 K（单位：个/小时），每个小时他会选择一颗蟠桃树，从中吃掉 K 个蟠桃，
     * 如果这棵树上的蟠桃数小于 K，他将吃掉这棵树上所有蟠桃，然后这一小时内不再吃其余蟠桃树上的蟠桃。
     * 孙悟空喜欢慢慢吃，但仍想在天兵天将回来前将所有蟠桃吃完。
     */
    public static void main(String[] args) {

        int[] peach = {332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184};
        int h = 823855818;
        int left = 1;
        int right = 1;
        for (int i:peach){
            right = Math.max(right, i);
        }
        while (left < right){
            int mid = left + (right - left) / 2;
            if (getMaxPeach(peach, mid, h)){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        System.out.println("孙悟空最慢一小时吃：\n"+(left)+"个桃子");
    }

    public static boolean getMaxPeach(int[] peach, int k, int h) {

        Long sum = 0L;
        for (int p : peach){
            sum += (p+k-1)/k;
        }
        if (sum <= h){
            return true;
        }else {
            return false;
        }
   }
}
