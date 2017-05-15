package easy;

/**
 * Created by rrr on 2017/5/15.
 * 303. Range Sum Query - Immutable
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

 Example:
 Given nums = [-2, 0, 3, -5, 2, -1]

 sumRange(0, 2) -> 1
 sumRange(2, 5) -> -1
 sumRange(0, 5) -> -3

 */
public class RangeSumQueryImmutable {
    //LeetCode解法
    int[] sum;

    public RangeSumQueryImmutable(int[] nums) {
        if (nums != null && nums.length != 0) {
            sum =new int[nums.length];
            sum[0]=nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum[i] = sum[i-1]+nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (i < 0) i = 0;
        if (j > sum.length - 1) j = sum.length - 1;
       return i==0? sum[j]: sum[j]- sum[i-1];
    }

    public static void main(String[] args) {
        RangeSumQueryImmutable s = new RangeSumQueryImmutable(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(s.sumRange(0, 2));
        System.out.println(s.sumRange(2, 5));
    }
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(sum);
 * int param_1 = obj.sumRange(i,j);
 */
}
