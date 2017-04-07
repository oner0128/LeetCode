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
        int j=0;
        for (int i = nums.length -1; i >= 0; i--) {
            j=i;
            while (j >= 0 && nums[j / 2] < nums[j]) {
                int tmp = nums[j];
                nums[j] = nums[j / 2];
                nums[j / 2] = tmp;
                j=j/2;
            }
        }
        int index=0;
        for (int i = 1; i < nums.length&&index<k; ) {
            if (nums[i]>=nums[])
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6,6, 4};
        System.out.println(Arrays.toString(nums));
        findKthLargest(nums,2);
        System.out.println(Arrays.toString(nums));
    }
}
