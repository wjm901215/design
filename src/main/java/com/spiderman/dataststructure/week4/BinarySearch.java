package com.spiderman.dataststructure.week4;

/**
 * 二分查找模版
 * <p>具体说明</p>
 *
 * @author SpiderMan
 * @version : com.spiderman.dataststructure.week4.BinarySearch,v 0.1 2/28/21 10:38 PM Exp $$
 */
public class BinarySearch {
    public int binarySearch(int[] array, int target) {
        //定义左,中,右指针
        int left = 0, right = array.length - 1, mid;
        while (left <= right) {
            // 计算中间节点
            mid = (right - left) / 2 + left;
            if (array[mid] == target) {
                //如果中间节点==目标节点则直接返回
                return mid;
            } else if (array[mid] > target) {
                //如果中间节点大于目标节点，则右指针左[移中间节点-1]
                right = mid - 1;
            } else {
                //如果中间节点小于目标节点，则左指针右移[中间节点+1]
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] arrry ={2,11,15,19,30,32,61,72,88,90,96};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarySearch(arrry,15));
    }
}
