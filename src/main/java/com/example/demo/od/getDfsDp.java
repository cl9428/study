package com.example.demo.od;

import java.util.*;

/**
 * **
 *  * 宝宝和妈妈参加亲子游戏，在一个二维矩阵（N*N）的格子地图上，宝宝和妈妈抽签决定各自的位置，<br/>
 *  * 地图上每个格子有不同的糖果数量，部分格子有障碍物。  游戏规则是妈妈必须在最短的时间<br/>
 *  * （每个单位时间只能走一步）到达宝宝的位置，路上的所有糖果都可以拿走，不能走障碍物的格子，<br/>
 *  * 只能上下左右走。  请问妈妈在最短到达宝宝位置的时间内最多拿到多少糖果<br/>
 *  * （优先考虑最短时间到达的情况下尽可能多拿糖果）。
 *  *
 */
public class getDfsDp {

    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 上右下左四个方向

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入矩阵的大小N:");
        int N = scanner.nextInt();
        int[][] matrix = new int[N][N];

        System.out.println("请输入矩阵内容:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        Arrays.stream(matrix)
                .map(Arrays::toString)
                .forEach(System.out::println);

        int maxCandies = collectCandies(matrix);
    }

    private static int collectCandies(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            System.out.println("妈妈无法到达宝宝位置");
            return -1;
        }
        int N = matrix.length;
        int startX = -1, startY = -1, endX = -1, endY = -1; // 初始化起点和终点坐标

        // 找到妈妈和宝宝的位置
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == -3) {
                    startX = i;
                    startY = j;
                } else if (matrix[i][j] == -2) {
                    endX = i;
                    endY = j;
                }
            }
        }

        if (startX == -1 || startY == -1 || endX == -1 || endY == -1) {
            System.out.println("无法找到妈妈和宝宝的位置");
            return -1;
        }
        if (startX == endX && startY == endY) {
            System.out.println("妈妈和宝宝在同一个位置");
            return -1;
        }

        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 0, 0}); // x, y, 步数, 当前糖果数
        visited[startX][startY] = true;

        int maxCandies = 0;

        while (!queue.isEmpty()) {

            for (int[] element : queue) {
                System.out.println("Element: " + Arrays.toString(element));
            }

            int[] current = queue.poll();
            int x = current[0], y = current[1], steps = current[2], candies = current[3];

            // 到达宝宝位置，更新最大糖果数
            if (x == endX && y == endY) {
                maxCandies = Math.max(maxCandies, candies);
                continue;
            }

            // 遍历四个方向
            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                // 检查新位置是否合法且未访问过
                if (newX >= 0 && newX < N && newY >= 0 && newY < N && !visited[newX][newY] && matrix[newX][newY] != -1) {
                    visited[newX][newY] = true;
                    // 如果新位置有糖果，则累加糖果数
                    int newCandies = candies + (matrix[newX][newY] > 0 ? matrix[newX][newY] : 0);
                    queue.offer(new int[]{newX, newY, steps + 1, newCandies});
                }

            }


        }
        Arrays.stream(visited)
                .map(Arrays::toString)
                .forEach(System.out::println);
        if (maxCandies == 0){
            System.out.println("无法到达宝宝位置");
            return -1;
        }
        System.out.println("最短路径下 最多糖果 maxCandies = " + maxCandies);
        return maxCandies;

    }
}
