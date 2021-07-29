package com.spiderman.dataststructure.week6;

/**
 * 打家劫舍
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.dataststructure.week6.RaidHome,v 0.1 2021/5/28 18:20 Exp $$
 */
public class RaidHome {
    /**
     * 采用二维数组,第二维存储是否被偷，0不偷，1偷
     * dp方程
     * db[i][0]=max(dp[i-1][0],dp[i-1][1])
     * dp[i][1]=dp[i-1][0] + nums[i]
     *
     * @param nums
     */
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[length - 1][0], dp[length - 1][1]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        RaidHome raidHome = new RaidHome();
        System.out.println(raidHome.rob(nums));
    }
}
