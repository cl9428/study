package com.example.demo.od;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class maxPeakFinderV3 {

    static List<Integer> getMaxPeakFinder(int[] nums, int n) {

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                list.add(i - 1);
            }
        }
        System.out.println(list);
        return list;
    }

    static List<Integer> getMaxPeak(int[] map, int n, int proMax) {

        List<Integer> keys = new ArrayList<>();
        List<Integer> starts = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            if (map[i] == 0 && map[i + 1] > 0) {
                starts.add(i);
            }
        }
        for (int i = 0; i < starts.size(); i++) {

            int start = starts.get(i) + 1;
            int currPower = 0;
            while (start < n && map[start] > 0) {

                currPower += Math.abs(map[start] - map[start - 1]);
                if (3 * currPower > proMax) {
                    break;
                }
                //边界
                if (start == n - 1 && start > 0) {
                    keys.add(start);
                }//中途
                else if (map[start] > map[start - 1] && map[start] > map[start + 1]) {
                    keys.add(start);
                }
                start++;
            }
        }
        return keys;
    }

    public static void main(String[] args) {

        int[] map = {0, 1, 2, 4, 3, 1, 0, 0, 1, 2, 3, 1, 2, 1, 0};
        int n = map.length;
        int proMax = 13;
        List<Integer> list = getMaxPeak(map, n, proMax);
        System.out.println(list);
        int[] mapRight = new int[n];
        // 定义两个指针，left 从头开始，right 从尾部开始
        int left = 0;
        int right = map.length - 1;
        // 当 left 小于 right 时，交换元素并移动指针
        while (left < right) {
            // 交换 map[left] 和 map[right]
            int temp = map[left];
            mapRight[left] = map[right];
            mapRight[right] = temp;
            // 移动指针
            left++;
            right--;
        }
        List<Integer> listRight = getMaxPeak(mapRight, n, proMax);
        // 由于使用了反转，得到的索引也是反转的，需要进一步处理才能得到原数组中的索引
        for (int i = 0; i < listRight.size(); i++) {
            listRight.set(i, n - listRight.get(i) - 1);
        }
        System.out.println(listRight);
        Set<Integer> set = new HashSet<>();
        set.addAll(list);
        set.addAll(listRight);
        System.out.println(set);
    }

}
