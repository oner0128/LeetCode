package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rrr on 2017/4/10.
 * 350. Intersection of Two Arrays II
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * <p>
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class IntersectionOfTwoArraysII {
    //two pointers
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int head1 = 0, head2 = 0;
        while (head1 < nums1.length && head2 < nums2.length) {
            if (nums1[head1] < nums2[head2]) head1++;
            else if (nums1[head1] > nums2[head2]) head2++;
            else {
                res.add(nums1[head1]);
                head1++;
                head2++;
            }
        }
        int[] ress = new int[res.size()];
        for (int i = 0; i < ress.length; i++) {
            ress[i] = res.get(i);
        }
        return ress;
    }
}

