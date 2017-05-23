package hard;

/**
 * Created by rrr on 2017/5/18.
 * 4. Median of Two Sorted Arrays
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianofTwoSortedArrays {
    //完全不会
    //LeetCode解法
    //思路：将两个数组分为left，right两部分，中位数位于左右部分的边界
    //https://discuss.leetcode.com/topic/16797/very-concise-o-log-min-m-n-iterative-solution-with-detailed-explanation/5
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2) return findMedianSortedArrays(nums2, nums1);
        int lo = 0, hi = len1*2;
        while (lo <= hi) {
            int mid1 = (lo + hi) / 2, mid2 = len1 + len2 - mid1;
            double l1=mid1==0?Double.MIN_VALUE:nums1[(mid1-1)/2];
            double l2=mid2==0?Double.MIN_VALUE:nums2[(mid2-1)/2];
            double r1=mid1==len1*2?Double.MAX_VALUE:nums1[mid1/2];
            double r2=mid2==len2*2?Double.MAX_VALUE:nums2[mid2/2];
            if (l1>r2)hi=mid1-1;
            else if (l2>r1)lo=mid1+1;
            else return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
        }
        return -1.0;
    }
}
