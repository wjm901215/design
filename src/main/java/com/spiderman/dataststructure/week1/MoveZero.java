package com.spiderman.dataststructure.week1;

import java.util.Arrays;

/**
 * 总体说明
 * <p>具体说明</p>
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.dataststructure.week1.MoveZero,v 0.1 1/29/21 6:16 PM Exp $$
 */
public class MoveZero {
//    public void moveZeroes(int[] nums) {
////        int j = 0;
////        for (int i = 0; i < nums.length; i++) {
////            if (nums[i] != 0) {
////                nums[j] = nums[i];
////                if (i != j) {
////                    nums[i] = 0;
////                }
////                j++;
////            }
////        }
////        Arrays.stream(nums).forEach(num -> {
////            System.out.print(num+",");
////        });
////    }

    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] data = {0,1,0,3,12};
        MoveZero solution = new MoveZero();
        solution.moveZeroes(data);

    }
}
