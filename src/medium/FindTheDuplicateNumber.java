package medium;

/**
 * Created by rrr on 2017/3/26.
 * 287. Find the Duplicate Number
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 Note:
 You must not modify the array (assume the array is read only).
 You must use only constant, O(1) extra space.
 Your runtime complexity should be less than O(n2).
 There is only one duplicate number in the array, but it could be repeated more than once.

 Tag:Binary Search/Array Two/Pointers
 自己能想到的思路：穷举法
 */
public class FindTheDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        if (nums.length > 1)
        {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast)
            {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;
            while (fast != slow)
            {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }

    public static void main(String[] args) {

//        System.out.println(new medium.FindTheDuplicateNumber().findDuplicate(new int[]{7, 1, 5, 3,4,3,6,2,8}));
        System.out.println(findDuplicate(new int[]{2,5 ,1 ,1, 4 ,3}));
    }
}
