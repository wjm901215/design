package com.spiderman.dataststructure.week1;

import java.util.Arrays;
import java.util.Stack;

/**
 * 总体说明
 * <p>具体说明</p>
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.dataststructure.week1.LargestRectangleArea,v 0.1 2/2/21 3:42 PM Exp $$
 */
public class LargestRectangleArea {

    /**
     * 暴力解法1
     * 1.循环判断该指针最左高度边界和最右高度边界
     * 2.算出宽度并求出最大面积
     */
    public int largestRectangleArea(int[] heights) {
        int leftBound = 0;
        int rightBound = 0;
        int maxArea = 0;
        for (int i = 0; i < heights.length; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (heights[i] <= heights[j]) {
                    leftBound = leftBound + 1;
                } else {
                    break;
                }
            }

            for (int k = i + 1; k < heights.length; ++k) {
                if (heights[i] <= heights[k]) {
                    rightBound = rightBound + 1;
                } else {
                    break;
                }
            }
            maxArea = Math.max(heights[i] * (leftBound + rightBound + 1), maxArea);
            leftBound = 0;
            rightBound = 0;
        }
        return maxArea;
    }

    /**
     * 使用栈解决
     * TODO
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea1(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> mono_stack = new Stack<Integer>();
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        mono_stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] data = {2, 1, 5, 6, 2, 3};
        LargestRectangleArea maxArea = new LargestRectangleArea();
        System.out.println(maxArea.largestRectangleArea1(data));

    }
}
