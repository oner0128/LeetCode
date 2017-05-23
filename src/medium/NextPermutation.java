package medium;

/**
 * Created by rrr on 2017/5/23.
 * 31. Next Permutation
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 */
public class NextPermutation {
    //LeetCode解法
    public void nextPermutation(int[] nums) {
        int i=nums.length-2;
        while (i>=0&&nums[i+1]<=nums[i])i--;
        if (i>=0){
            int j=nums.length-1;
            while (j>i&&nums[j]<=nums[i])j--;
            swap(nums,i,j);
        }
        reverse(nums,i+1);
    }

    private void reverse(int[] nums, int i) {
        int j=nums.length-1;
        while (i<j){
            swap(nums,i++,j--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
