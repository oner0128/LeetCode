package HashTable;

import java.util.*;

/**
 * Created by rrr on 2017/4/10.
 * 349. Intersection of Two Arrays
 * Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class IntersectionOfTwoArrays {
    //HashTable 7 ms
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);
        if (set1.size() > set2.size()) {
            for (int num : set2) if (set1.contains(num)) res.add(num);
        } else for (int num : set1) if (set2.contains(num)) res.add(num);
        int[] ress = new int[res.size()];
        for (int i = 0; i < ress.length; i++) {
            ress[i] = res.get(i);
        }
        return ress;
    }

    //two pointers 4ms
    public int[] intersection2(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int head1 = 0, head2 = 0;
        while (head1 < nums1.length && head2 < nums2.length) {
            if (nums1[head1] < nums2[head2]) {
                while (head1 < nums1.length - 1 && nums1[head1] == nums1[head1 + 1]) head1++;
                head1++;
            } else if (nums1[head1] > nums2[head2]) {
                while (head2 < nums2.length - 1 && nums2[head2] == nums2[head2 + 1]) head2++;
                head2++;
            } else {
                res.add(nums1[head1]);
                while (head1 < nums1.length - 1 && nums1[head1] == nums1[head1 + 1]) head1++;
                while (head2 < nums2.length - 1 && nums2[head2] == nums2[head2 + 1]) head2++;
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

    //Binary Search 8ms
    public int[] intersection3(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[0];
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n=0;int num;
        while (n<nums2.length){
            num=nums2[n];
            int lo = 0, hi = nums1.length - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (num == nums1[mid]) {res.add(num);break;}
                else if (num > nums1[mid]) lo = mid + 1;
                else hi = mid - 1;
            }
            while (n < nums2.length - 1 && nums2[n] == nums2[n + 1]) n++;
            n++;
        }
        int[] ress = new int[res.size()];
        for (int i = 0; i < ress.length; i++) ress[i] = res.get(i);
        return ress;
    }
    public static void main(String[] args) {
        int[] nums1 = {7, 1, 5, 3, 6, 4};
        int[] nums2 = {1, 3}; System.out.println(Arrays.toString(new IntersectionOfTwoArrays().intersection2(nums1,nums2)));
        System.out.println(Arrays.toString(new IntersectionOfTwoArrays().intersection3(nums1,nums2)));

    }
}
