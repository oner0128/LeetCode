/**
 * Created by rrr on 2017/4/5.
 * 154. Find Minimum in Rotated Sorted Array II
 * Follow up for "Find Minimum in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * The array may contain duplicates.
 */
public class FindMinimumInRotatedSortedArrayII {
    public static int findMin(int[] nums) {
        int index1 = 0, index2 = nums.length - 1;
        int indexMid;
        while (index1 < index2) {
            indexMid = index1 + (index2 - index1) / 2;
            if (nums[index1] == nums[indexMid] && nums[indexMid] == nums[index2]) {
                return findMinOrder(nums, index1, index2);
            }
            if (nums[index2] >= nums[indexMid]) index2 = indexMid;
            else if (nums[index2] < nums[indexMid] ) index1 = indexMid + 1;
        }
        return nums[index1];
    }

    private static int findMinOrder(int[] nums, int index1, int index2) {
        int min = nums[index1];
        for (int i = index1 + 1; i <= index2; i++) {
            min = Math.min(min, nums[i]);
        }
        return min;
    }
    //LeetCode大神解法
//    When num[mid] == num[hi], we couldn't sure the position of minimum in mid's left or right, so just let upper bound reduce one.
    public static int findMin2(int[] num) {
        int lo = 0;
        int hi = num.length - 1;
        int mid = 0;

        while(lo < hi) {
            mid = lo + (hi - lo) / 2;

            if (num[mid] > num[hi]) {
                lo = mid + 1;
            }
            else if (num[mid] < num[hi]) {
                hi = mid;
            }
            else { // when num[mid] and num[hi] are same
                hi--;
            }
        }
        return num[lo];
    }


    public static void main(String[] args) {
        System.out.println(findMin(new int[]{5, 6, 7, 8, 1, 2, 3, 4}));
        System.out.println(findMin(new int[]{5, 6, 7, 8, 1, 2, 3, 4, 5}));
        System.out.println(findMin(new int[]{2, 3, 4, 5, 6, 7, 8, 1, 2}));
        System.out.println(findMin(new int[]{3, 1, 1}));System.out.println(findMin(new int[]{3, 3, 1}));
        System.out.println(findMin(new int[]{1, 3, 3}));
        System.out.println(findMin(new int[]{1, 1, 3}));
        System.out.println(findMin(new int[]{3,3, 1, 1}));
        System.out.println(findMin(new int[]{1,1, 3, 3}));;
        System.out.println(findMin(new int[]{0, 2, 3, 4, 5, 6, 7}));
        System.out.println(findMin(new int[]{1, 1, 0, 1, 1, 1, 1}));
    }
}
