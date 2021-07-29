package com.spiderman.dataststructure.week1;

/**
 * 总体说明
 * <p>具体说明</p>
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.dataststructure.week1.RemoveDuplicates,v 0.1 1/31/21 10:41 PM Exp $$
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }
        return j+1;

    }

    public static void main(String[] args) {
        int[] nums = {1, 1,2};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        System.out.println(removeDuplicates.removeDuplicates(nums));

    }
}
