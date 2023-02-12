package com.bii.alg;

/**
 * 二分查找, 运行时间为对数时间log2 n，二分查找也是分治算法的一种体现
 *
 * @author bihaiyang
 * @desc
 * @since 2022/11/30
 */
public class BinarySearchNoRecursion {
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 12, 32, 51, 66, 123, 124, 334};
        int i = binarySearch(nums, 12);
        System.out.println(i);
    }
    
    public static int binarySearch(int[] nums, int n) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == n) {
                return mid;
            } else if (nums[mid] < n) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return -1;
    }
}
