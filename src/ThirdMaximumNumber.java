import java.util.Arrays;

/**
 * Created by rrr on 2017/4/7.
 * 414. Third Maximum Number
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
 * <p>
 * Example 1:
 * Input: [3, 2, 1]
 * <p>
 * Output: 1
 * <p>
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 * <p>
 * Output: 2
 * <p>
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 * <p>
 * Output: 1
 * <p>
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 */
public class ThirdMaximumNumber {
    public static int thirdMax(int[] nums) {
        if (nums.length < 3) return nums.length == 2 ? (nums[0] >= nums[1] ? nums[0] : nums[1]) : nums[0];
        int third, first, second;
        third = first = second = nums[0];
        boolean firstMarked, secondMarked, thirdMarked;
        firstMarked = secondMarked = thirdMarked = false;
        int tmpFirst = first;
        int tmpSecond = second;
        for (int num : nums) {
            if (first < num) {
                tmpFirst = first;
                first = num;
                firstMarked = true;
            }
            if (second < num || firstMarked) {
                tmpSecond = second;
                if (firstMarked == true) {
                    if (second == tmpFirst) {
                        firstMarked = false;
                        secondMarked = false;
                        continue;
                    }
                    second = tmpFirst;
                    secondMarked = true;
                } else if (num < first) {
                    second = num;
                    secondMarked = true;
                }
            }
            if (third <= num || secondMarked) {
                if (secondMarked == true) {
                    if (third == tmpSecond) {
                        firstMarked = false;
                        secondMarked = false;
                        continue;
                    }
                    third = tmpSecond;
                    thirdMarked = true;
                } else if (num < second) {
                    third = num;
                    thirdMarked = true;
                }
            }
            firstMarked = false;
            secondMarked = false;
        }
        return thirdMarked == true ? third : first;
    }

    public static int thirdMax2(int[] nums) {
        if (nums.length < 3) return nums.length == 2 ? (nums[0] >= nums[1] ? nums[0] : nums[1]) : nums[0];
        int third, first, second;
        third = first = second = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (third==second){third=Math.min(third,nums[i]);}
            if (third >= nums[i] ) continue;
            if (second >= nums[i]) {
                third = second == nums[i] ? third : nums[i];
                continue;
            }
            if (first > nums[i]) {
                third = second;
                second = nums[i];
                continue;
            } else if (first < nums[i]){
                third = second;
                second = first;
                first = nums[i];
            }
        }
        return third == second ? first : third;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(nums));
        System.out.println(thirdMax2(nums));
        int[] nums2 = {1, 2, -2147483648};
        System.out.println(Arrays.toString(nums2));
        System.out.println(thirdMax2(nums2));
        int[] nums3 = {2, 3, 3, 1};
        System.out.println(Arrays.toString(nums3));
        System.out.println(thirdMax2(nums3));
        int[] nums4 = {4, 3, 2, 1};
        System.out.println(Arrays.toString(nums4));
        System.out.println(thirdMax2(nums4));
        int[] nums5 = {5, 2, 2, 1};
        System.out.println(Arrays.toString(nums5));
        System.out.println(thirdMax2(nums5));
        int[] nums6 = {1, -2147483648, 2};
        System.out.println(Arrays.toString(nums6));
//        System.out.println(thirdMax(nums6));
        System.out.println(thirdMax2(nums6));
    }
}
