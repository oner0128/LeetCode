package medium;

/**
 * Created by rrr on 2017/4/5.
 * 162. Find Peak Element
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -∞.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 */
public class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;
        int mid ;
        if (nums.length==1)return 0;//因为num[-1] = num[n] = -∞，所以只有一个数时，peak即为该值
        if (nums[low] > nums[low + 1]) return low;//多个峰值只需求出一个，利用条件num[-1] = num[n] = -∞，优先判断数组两边的值是否为峰值
        if (nums[high] > nums[high - 1]) return high;
        while (low < high) {
            mid = low + (high - low) / 2;
//            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) return mid;
            if (nums[mid] < nums[mid+1]) low = mid+1;//利用递增还是递减来缩短边界，若是递增，则low=mid+1
            else if (nums[mid] > nums[mid+1]) high = mid;//若是递增，则high = mid
        }
        return low;
    }
    //LeetCode大神解法
    public static int findPeakElement2(int[] num)
    {
        int low = 0;
        int high = num.length-1;

        while(low < high)
        {
            int mid1 = (low+high)/2;
            int mid2 = mid1+1;
            if(num[mid1] < num[mid2])
                low = mid2;
            else
                high = mid1;
        }
        return low;
    }
    public static void main(String[] args) {
//        System.out.println(findPeakElement(new int[]{5, 6, 7, 8, 1, 2, 3, 4}));
//        System.out.println(findPeakElement(new int[]{5, 6, 7, 8, 1, 2, 3, 4, 5}));
//        System.out.println(findPeakElement(new int[]{2, 3, 4, 5, 6, 7, 8, 1, 2}));
        System.out.println(findPeakElement(new int[]{1, 2, 3, 4, 1}));
        System.out.println(findPeakElement(new int[]{1, 2, 5, 4, 3, 2, 1}));
        System.out.println(findPeakElement(new int[]{1, 4, 3, 2, 1}));
        System.out.println(findPeakElement(new int[]{1, 2, 3, 4}));
        System.out.println(findPeakElement(new int[]{4, 3, 2, 1}));
        System.out.println(findPeakElement(new int[]{1}));
        System.out.println(findPeakElement(new int[]{1,0}));
    }
}
