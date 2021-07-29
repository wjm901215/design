package com.spiderman.dataststructure.week5;

/**
 * 不同路径
 * <p>具体说明</p>
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.dataststructure.week5.UniquePaths,v 0.1 3/10/21 6:38 PM Exp $$
 */
public class UniquePaths {
    /**
     * 公式 int[i][j]=dp[i-1][j]+dp[j-1][i]
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 || j == n - 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3,2));
    }
}
