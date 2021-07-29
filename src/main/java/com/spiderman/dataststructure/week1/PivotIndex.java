package com.spiderman.dataststructure.week1;

/**
 * 724. 寻找数组的中心索引
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.dataststructure.week1.PivotIndex,v 0.1 1/28/21 11:39 AM Exp $$
 */
public class PivotIndex {

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //中心位置左半和
        int leftSum = 0;
        //中心位置右半和
        int rightSum = 0;
        for (int i = 0; i < nums.length ; i++) {
            leftSum += nums[i];
            rightSum = sum - leftSum + nums[i];
            if(leftSum == rightSum){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
//        int[] nums = {-1,-1,0,1,1,0};
        int[] nums = {1, 7, 3, 6, 5, 6};
        PivotIndex pivotIndex = new PivotIndex();
        System.out.println(pivotIndex.pivotIndex(nums));

    }
}
