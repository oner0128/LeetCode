package medium;

import java.util.Arrays;

/**
 * Created by rrr on 2017/4/7.
 * 215. Kth Largest Element in an Array
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestElementInAnArray {
    public static void findKthLargest(int[] nums,int k) {
        int index=0;int tmp;
        for (int i = (nums.length-1)/2-1; i >= 0; i--) {
            index=i;
            while (index <= (nums.length-1)/2-1 && (nums[index * 2+1] > nums[index]||nums[index * 2+2] > nums[index])) {
                int child=nums[index * 2+1] > nums[index * 2+2]?index * 2+1:index * 2+2;
                tmp = nums[child];
                nums[child] = nums[index];
                nums[index] = tmp;
                index=child;
            }
        }
        System.out.println(Arrays.toString(nums));
        int len=nums.length-1;
        while (k>1){
            index=0;
            tmp = nums[len];
            nums[len] = nums[index];
            nums[index] = tmp;
            len--;
            while (index <= len/2-1 && (nums[index * 2+1] > nums[index]||nums[index * 2+2] > nums[index])) {
                int child=nums[index * 2+1] > nums[index * 2+2]?index * 2+1:index * 2+2;
                tmp = nums[child];
                nums[child] = nums[index];
                nums[index] = tmp;
                index=child;
            }k--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6,6, 4};
        System.out.println(Arrays.toString(nums));
        findKthLargest(nums,3);
        System.out.println(Arrays.toString(nums));
    }
}
