package com.spiderman.dataststructure.week6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 三角形最小路径 和
 * <p>具体说明</p>
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.dataststructure.week6.Triangle,v 0.1 4/27/21 7:42 AM Exp $$
 */
public class Triangle {
    /**
     * 二维数组求解
     * 时间复杂度：O(N^2) N 为三角形的行数。
     * 空间复杂度：O(N^2) N 为三角形的行数
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        // 加1可以不用初始化最后一层
        int[][] dp = new int[size + 1][size + 1];
        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j <= i; ++j) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    /**
     * 一维数组求解
     * 时间复杂度：O(N^2) N 为三角形的行数。
     * 空间复杂度：O(N)   N 为三角形的行数
     */
    public static int minimumOneTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        // 加1可以不用初始化最后一层
        int[] dp = new int[size + 1];
        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j <= i; ++j) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }


    public static void main(String[] args) {
        int[][] triangle = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        List<List<Integer>> triangles = convertArray(triangle);
        System.out.println(minimumTotal(triangles));
        System.out.println(minimumOneTotal(triangles));
    }

    /**
     * 二维数组转集合
     *
     * @param triangle
     * @return
     */
    private static List<List<Integer>> convertArray(int[][] triangle) {
        List<List<Integer>> triangleList = new ArrayList<>();
        for (int i = 0; i < triangle.length; i++) {
            List<Integer> columnList = new ArrayList<>();
            for (int j = 0; j < triangle[i].length; j++) {
                columnList.add(j, triangle[i][j]);
            }
            triangleList.add(i, columnList);
        }
        return triangleList;
    }

}
