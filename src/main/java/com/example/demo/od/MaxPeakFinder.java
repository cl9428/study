package com.example.demo.od;

/**
 * 攀登者喜欢寻找各种地图，并且尝试攀登到最高的山峰。
 * 地图表示为一维数组，数组的索引代表水平位置，数组的元素代表相对海拔高度。其中数组元素0代表地面。
 * 例如：[0,1,2,4,3,1,0,0,1,2,3,1,2,1,0]，代表如下图所示的地图，地图中有两个山脉位置分别为
 * 1,2,3,4,5 和 8,9,10,11,12,13，最高峰高度分别为 4,3。最高峰位置分别为3,10。
 * 一个山脉可能有多座山峰(高度大于相邻位置的高度，或在地图边界且高度大于相邻的高度)。
 * 登山者想要知道一张地图中有多少座山峰。
 */
public class MaxPeakFinder {

    public static void main(String[] args)
    {
        int[] map = {0,1,2,4,3,1,0,0,1,2,3,1,2,1,0};
        int n = map.length;
        System.out.println(getMaxPeak(map, n));
    }
    static int getMaxPeak(int[] map, int n){
        int count = 0;
        for(int i = 1; i < n - 1; i++){
            if(map[i] > map[i - 1] && map[i] > map[i + 1]){
                count++;
            }
        }
        return count;
    }
}
