package medium;

import java.util.Arrays;

/**
 * Created by rrr on 2017/3/5.
 * 34. Search for a Range
 * Given an array of integers sorted in ascending order,
 * find the starting and ending position of a given target value.
 Your algorithm's runtime complexity must be in the order of O(log n).
 If the target is not found in the array, return [-1, -1].
 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 */
public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        int[] range = {-1, -1};
        int mid = lo + (hi - lo) / 2;
        while (lo <= hi) {//按照二分查找看该数是否存在
            if (nums[mid] > target) hi = mid - 1;
            else if (nums[mid] < target) lo = mid + 1;
            else {
                // /若存在，则在【lo,mid-1],[mid+1,hi]中
                // 按照二分查找继续寻找边界，但是上下边界设定有区别。
                int j1, i2, imid, jmid;
                i2 = mid;
                j1 = mid;
                while (lo <= i2) {
                    imid = (lo + i2) / 2;
                    if (nums[imid] == target) i2 = imid - 1;
                    else if (nums[imid] < target) lo = imid + 1;
                }
                while (j1 <= hi) {
                    jmid = (j1 + hi) / 2;
                    if (nums[jmid] > target) hi = jmid - 1;
                    else if (nums[jmid] == target) j1 = jmid + 1;
                }
                range[0] = lo;
                range[1] = hi;
                return range;
            }
            mid = lo + (hi - lo) / 2;
        }
        return range;
    }
    //先求左边界，再求边界
    public static int[] searchRange2(int[] nums, int target) {
    int i = 0, j = nums.length - 1;int[] range = {-1, -1};
    // Search for the left one
    while (i < j)
    {
        int mid = (i + j) /2;
        if (nums[mid] < target) i = mid + 1;
        else j = mid;
    }
    if (nums[i]!=target) return range;
    else range[0] = i;

    // Search for the right one
    j = nums.length - 1;  // We don't have to set i to 0 the second time.
    while (i < j)
    {
        int mid = (i + j) /2 + 1;	// Make mid biased to the right
        if (nums[mid] > target) j = mid - 1;
        else i = mid;				// So that this won't make the search range stuck.
    }
        range[1] = j;
    return range;}

    public static void main(String[] args) {
        int[] range = {5, 7, 7, 8, 8, 8, 8};
        int[] range2 = {5, 6, 6, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 10, 11};
        int[] range3 = {11, 11, 11, 11};
        System.out.println(Arrays.toString(searchRange(range, 8)));
        System.out.println(Arrays.toString(searchRange(range, 4)));
        System.out.println(Arrays.toString(searchRange(range2, 8)));
        System.out.println(Arrays.toString(searchRange(range3, 11)));
    }
}
