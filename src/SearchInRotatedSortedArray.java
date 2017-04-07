/**
 * Created by rrr on 2017/4/6.
 * 33. Search in Rotated Sorted Array Add to List
 DescriptionSubmissionsSolutions
 Total Accepted: 158265
 Total Submissions: 492872
 Difficulty: Medium
 Contributor: LeetCode
 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 You are given a target value to search. If found in the array return its index, otherwise return -1.
 You may assume no duplicate exists in the array.
 */
public class SearchInRotatedSortedArray {
    //思路：先找到旋转的数，然后分别对第一个递增数组和第二个递增数组进行二分查找
    public static int search(int[] nums, int target) {
        int index1=0,index2=nums.length-1;
        //find rotated index
        while (index1<index2){
            int indexMid=index1+(index2-index1)/2;
             if (nums[indexMid]>nums[index2])index1=indexMid+1;
            else index2=indexMid;
        }
        int rotatedIndex=index1;
        //find target in 1th array
        index1=0;index2=rotatedIndex-1;
        while (index1<=index2&&target<=nums[index2]){
            int indexMid=index1+(index2-index1)/2;
            if (nums[indexMid]==target)return indexMid;
            if (nums[indexMid]>target)index2=indexMid-1;
            else index1=indexMid+1;
        }
        //find target in 2nd array
        index1=rotatedIndex;index2=nums.length-1;
        while (index1<=index2&&target<=nums[index2]){
            int indexMid=index1+(index2-index1)/2;
            if (nums[indexMid]==target)return indexMid;
            if (nums[indexMid]>target)index2=indexMid-1;
            else index1=indexMid+1;
        }
        return -1;
    }
    //思路：先找到旋转的数，然后分别对第一个递增数组和第二个递增数组进行二分查找
    //LeetCode大神解法
    // 优化：在二分查找过程中考虑因旋转导致真正中心偏移，即计算真正的中心
    public static int search2(int[] nums, int target) {
        int index1=0,index2=nums.length-1;
        //find rotated index
        while (index1<index2){
            int indexMid=index1+(index2-index1)/2;
            if (nums[indexMid]>nums[index2])index1=indexMid+1;
            else index2=indexMid;
        }
        int rotatedIndex=index1;
        //find target with binary search and acconting in rotated
        index1=0;index2=nums.length-1;
        while (index1<=index2){
            int indexMid=index1+(index2-index1)/2;
            int realMid=(indexMid+rotatedIndex)%nums.length;
            if (nums[realMid]==target)return realMid;
            if (nums[realMid]>target)index2=indexMid-1;//考虑旋转后边界取值仍为偏移中心
            else index1=indexMid+1;
        }

        return -1;
    }
    //LeetCode大神解法
    /*思路：直接在原数组进行二分查找，
        1.若A[lo] <= A[mid]说明mid位于第一递增数组
            1.1若A[lo] <= target < A[mid],说明target在lo-mid,则hi=mid-1
            1.2若target > A[mid],说明target在mid-hi,则lo=mid+1
        2.若A[lo] > A[mid]说明mid位于第二递增数组
            2.1若A[mid] < target <= A[hi],说明target在mid-hi,则lo=mid+1
            2.2若A[mid] > target,说明target在lo-mid,则hi=mid-1
        若存在target则lo=index
        return A[lo] == target ? lo : -1;
    */
    public int search3(int[] A, int target) {
        int lo = 0;
        int hi = A.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (A[mid] == target) return mid;

            if (A[lo] <= A[mid]) {
                if (target >= A[lo] && target < A[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > A[mid] && target <= A[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return A[lo] == target ? lo : -1;
    }
    public static void main(String[] args) {
        System.out.println(search(new int[]{5, 6, 7, 8, 1, 2, 3, 4},5));
        System.out.println(search(new int[]{5, 6, 7, 8,9, 1, 2, 3, 4},4));
        System.out.println(search(new int[]{ 3,4, 5, 6, 7, 8, 1, 2},9));
        System.out.println(search2(new int[]{9, 0, 2, 3, 4, 5, 6, 7},9));
        System.out.println(search(new int[]{0, 2, 3, 4, 5, 6, 7},0));
    }
}
