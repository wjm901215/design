package com.spiderman.dataststructure.week1;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.dataststructure.week1.SumNum,v 0.1 1/29/21 10:06 PM Exp $$
 */
public class SumNum {
    /**
     * 解法1:暴力求解使用两层循环
     */

    public int[] twoSum(int[] nums, int target) {
        int [] result =new int[2];
        for (int i =0; i < nums.length-1; ++i) {
            for (int j=1; j <nums.length; j++) {
                if (nums[i]+nums[j]==target) {
                    result[0] = nums[i];
                    result[1] = nums[j];
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 利用hash进行处理
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i < nums.length; ++i) {
            if (map.containsKey(target-nums[i])) {
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] data = {2,7,11,15};
        SumNum solution = new SumNum();
        solution.twoSum(data,9);
        solution.twoSum1(data,9);
    }
}
