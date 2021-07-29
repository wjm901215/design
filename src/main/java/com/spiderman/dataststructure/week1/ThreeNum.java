package com.spiderman.dataststructure.week1;

import java.util.*;

/**
 * 三数之和
 * <p>具体说明</p>
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.dataststructure.week1.ThreeNum,v 0.1 1/29/21 10:34 PM Exp $$
 */
public class ThreeNum {
    //解法1:暴力解法，使用3层循环
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; ++i) {
            for (int j = i + 1; j < nums.length - 1; ++j) {
                for (int k = j + 1; k < nums.length; ++k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> integers = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(integers);
                        set.add(integers);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    //1.首先对数组进行排序
    //2.定义K指针从0开始，L和R指针分别从k+1,length-1进行遍历
    //3.while(l<r)判断k+l+r是否=0，等于0则加入数组中
    //4.大于k则r--，小于k，则i++
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        if (nums.length < 2) {
            return list;
        }
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; ++k) {
            if  (nums[k] > 0) {
                return list;
            }
            if (k > 0 && nums[k]==nums[k-1]) continue;
            int l = k+1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[k] + nums[l] + nums[r];
                if (sum == 0 ) {
                    list.add(Arrays.asList(nums[k],nums[l],nums[r]));
                    while(l < r && nums[l] == nums[++l]);
                    while(l < r && nums[r] == nums[--r]);
                } else if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                }
            }

        }
        return list;
    }


    /**
     *1.首先判断nums是否为null，并且nums的length必须大于2
     *2.对数组进行排序，定义双指针，l和r，l从左边开始，r从右边开始
     *3.循环判断l<r,nums[i]+nums[l]+nums[r]是否为0，如果小于0则左指针右移，如果大于0则右指针左移
     *4.如果等于0，则找到三数之和，并将l往左移，r往右边移
     */
    public List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length <= 2) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (i > 0 && nums[i]==nums[i-1]) continue;
            int l = i + 1,r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while (l < r && nums[l] == nums[++l]);
                    while (l < r && nums[r] == nums[--r]);
                }else if (sum < 0) {
                    l++;
                }else if (sum > 0) {
                    r--;
                }
            }
        }
        return result;
    }

    /**
     *1.首先判断nums是否为null，并且nums的length必须大于3
     *2.对数组进行排序，定义外层循环从i=0开始
     *3.内存循环从j=i+1开始,使用双指针，l和r，l从左边开始，r从右边开始，夹璧法
     *3.循环判断l<r,nums[i]+nums[j]+nums[l]+nums[r]是否为0，如果小于0则左指针右移，如果大于0则右指针左移
     *4.如果等于0，则找到四数之和，并将l往左移，r往右边移
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3)  {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; ++i) {
            //外层循环去重
            if (i > 0 && nums[i]==nums[i-1]) continue;
            for (int j = i + 1; j < nums.length - 2 ; ++j) {
                //内层循环去重
                if (j > i + 1 && nums[j]==nums[j-1]) continue;
                int l = j + 1,r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        //内存循环左指针去重
                        while (l < r && nums[l] == nums[++l]);
                        //内存循环右指针去重
                        while (l < r && nums[r] == nums[--r]);
                    }else if (sum < target) {
                        l++;
                    }else if (sum > target) {
                        r--;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] data = {-2,-1,-1,1,1,2,2};
        ThreeNum solution = new ThreeNum();
        List<List<Integer>> lists = solution.fourSum(data,0);
        lists.stream().forEach(item->{
            System.out.println(item.toString());
        });
    }
}
