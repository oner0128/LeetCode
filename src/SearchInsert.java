import java.util.Arrays;

/**
 * Created by rrr on 2017/2/14.
 */
public class SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        if (nums.length<1)return 0;
        int begin = 0, end = nums.length-1 ;
        int index =0;
        while (begin <=end) {
            index = begin + (end - begin) / 2;
            if (nums[index] > target) {
                end=index-1;
            } else if (nums[index] < target){
                begin=index+1;
            }else return index;
        }
        return begin;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5,7,9,11,13,45,56};
        System.out.println(Arrays.toString(nums));
        System.out.println(searchInsert(nums, 0));
        System.out.println(searchInsert(nums, 2));
        System.out.println(searchInsert(nums, 4));
        System.out.println(searchInsert(nums, 6));
        System.out.println(searchInsert(nums, 8));
        System.out.println(searchInsert(nums, 10));
        System.out.println(searchInsert(nums, 12));
        System.out.println(searchInsert(nums, 14));
        int[] nums2 = {};System.out.println(searchInsert(nums2, 5));
        int[] nums3 = {5};System.out.println(searchInsert(nums3, 1));System.out.println(searchInsert(nums3, 8));
    }
}
