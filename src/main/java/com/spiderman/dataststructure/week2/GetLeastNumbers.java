package com.spiderman.dataststructure.week2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 最小的k个数
 * <p>具体说明</p>
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.dataststructure.week2.GetLeastNumbers,v 0.1 2/9/21 4:11 PM Exp $$
 */
public class GetLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];
        if (k == 0) {
            return result;
        }
        Queue<Integer> heap = new PriorityQueue<>(k, (o1, o2) -> o2-o1);
        for (int i = 0; i < arr.length; ++i) {
            if (heap.size() < k) {
                heap.add(arr[i]);
            }else if(arr[i] < heap.peek()) {
                heap.poll();
                heap.add(arr[i]);
            }
        }
        int i = 0;
        while (!heap.isEmpty()) {
            result[i++] = heap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,2,0,5};
        GetLeastNumbers solution = new GetLeastNumbers();
        int result[] = solution.getLeastNumbers(nums, 0);
        Arrays.stream(result).forEach(t -> System.out.println(t));

    }
}
