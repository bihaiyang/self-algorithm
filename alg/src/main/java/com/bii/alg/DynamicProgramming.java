package com.bii.alg;

import java.util.Arrays;

/**
 * @author bihaiyang
 * @desc 动态规划：将大问题划分为小问题进行解决，从而一步步获取最优解的处理算法 与分治算法不同的是动态规划是每一步的解都会依赖上一步的解 0 1 背包问题
 * <p>
 * 思路，每次遍历到第i个物品，根据weight[i] 和 value[i] 来确定是否需要将该物品放入背包中。即对于给定的n个物品 再令v[i][j]
 * 表示在前i个物品中能够装入容量为j的背包中最大价值。则我们有下面的结果：
 * @since 2022/11/30
 */
public class DynamicProgramming {
    
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {100, 200, 300};
        int capacity = 4;

        int n = value.length;
        int[][] v = new int[n + 1][capacity + 1];
        pack(v, weight, value);
        for (int[] item : v) {
            System.out.println(Arrays.toString(item));
        }
        
    }
    
    public static void pack(int[][] v, int[] weight, int[] value) {
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[i].length; j++) {
                if (weight[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
                    v[i][j] = Math.max(v[i - 1][j], value[i - 1] + v[i - 1][j - weight[i - 1]]);
                }
            }
        }
    }
}
