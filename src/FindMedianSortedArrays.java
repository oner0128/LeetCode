/**
 * Created by rrr on 2017/3/6.
 */
public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int i = len1 / 2, j = len2 / 2;
        if (nums1[i] > nums2[j]) {
            int mid = (nums1[i] + nums2[j]) / 2;
            while (j < len2 - 1 && nums2[j] > nums2[j + 1])j++;
        }else if (nums1[i] > nums2[j]){}
        else return nums1[i];
        return 0.0;
    }

    public static void main(String[] args) {
        int[] nums1={0,1,2,2,2,8};int[] nums2={1,1,2,2,3,9,10};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
