package com.spiderman.dataststructure.week1;

/**
 * 盛最多水的容器
 * <p>具体说明</p>
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.dataststructure.week1.MaxArea,v 0.1 1/27/21 5:31 PM Exp $$
 */
public class MaxArea {
    //解法1：利用双重循环进行遍历，外层循环从0开始，内层循环从1开始 计算出对应面积（按高度小的的一端进行比较），比较面积大小（保留大数）
    public int maxArea(int[] height) {
        int area = 0;
        for (int i = 0; i < height.length - 1; ++i) {
            for (int j = i + 1; j < height.length; ++j) {
                int y = Math.min(height[i], height[j]);
                area = Math.max(area, y * (j - i));
            }
        }
        return area;
    }


    /**
     * 使用一层循环，左右指针，相互比较小的一端往中间移动+1，往中间收拢直到重合
     */
    public int maxArea1(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int lowHeight;
//            int lowHeight = height[i] < height[j] ? height[i++] : height[j--];
            if (height[i] < height[j]) {
                lowHeight = height[i];
                i++;
            } else {
                lowHeight = height[j];
                j--;
            }
            int area = lowHeight * (j - i + 1);
            max = Math.max(max, area);
        }
        return max;

    }

    /**
     * 利用双指针，一次遍历i=0，j=length-1，分别往中间汇聚
     */
    public int maxArea2(int[] height) {
        int i = 0,j = height.length - 1, maxArea = 0;
        int setp = height.length - 1;
        while (i <= j) {
            int lowHeight = height[i] < height[j] ? height[i++] : height[j--];
            maxArea = Math.max(maxArea,lowHeight * setp--);
        }
        return maxArea;

    }




    public static void main(String[] args) {
        int[] data = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        MaxArea maxArea = new MaxArea();
        System.out.println(maxArea.maxArea(data));

    }
}
