import java.util.*;

/**
 * Created by rrr on 2017/3/6.
 * 16. 3Sum Closest
 * 思路：跟3sum一样，在循环中多加一个条件判断sum是否比原先的Sum更接近Target
 * */
public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int closestSum=nums[0]+nums[1]+nums[2];
        int i = 0;
        while(i < nums.length - 2) {
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target) return target;
                if (Math.abs(sum-target)<Math.abs(closestSum-target))closestSum=sum;
                if(sum < target) while(nums[j] == nums[++j] && j < k);
                if(sum > target) while(nums[k--] == nums[k] && j < k);
            }
            while(nums[i] == nums[++i] && i < nums.length - 2);
        }
        return closestSum;
    }

    public static void main(String[] args) {
        int[] nums={-1,2,1,-4,1,0};
        System.out.println(threeSumClosest(nums,5));
        int[]nums2={6,-18,-20,-7,-15,9,18,10,1,-20,-17,-19,-3,-5,-19,10
                ,6,-11,1,-17,-15,6,17,-18,-3,16,19,-20,-3,-17,-15,-3,12,1
                ,-9,4,1,12,-2,14,4,-4,19,-20,6,0,-19,18,14,1,-15,-5,14,12
                ,-4,0,-10,6,6,-6,20,-8,-6,5,0,3,10,7,-2,17,20,12,19,-13,-1
                ,10,-1,14,0,7,-3,10,14,14,11,0,-4,-15,-8,3,2,-5,9,10,16,-4
                ,-3,-9,-8,-14,10,6,2,-12,-7,-16,-6,10};
        System.out.println(threeSumClosest(nums2,-52));

    }
}
