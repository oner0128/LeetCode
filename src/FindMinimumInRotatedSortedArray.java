/**
 * Created by rrr on 2017/3/26.
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * Find the minimum element.
 */
public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        int head = 0, rear = nums.length - 1;
        int min = nums[rear], middle;
        while (head < rear) {
            middle = head + (rear - head) / 2;
            if (nums[middle] >= nums[middle + 1]) return nums[middle + 1];
            if (nums[middle] < min) {
                rear = middle;
                min = nums[rear];
            } else {
                head = middle;
            }
        }
        return min;
    }
    //LeetCode大神解法
    public static int findMin2(int[] num) {
        int low = 0, high = num.length - 1;
        // loop invariant: 1. low < high
        //                 2. mid != high and thus A[mid] != A[high] (no duplicate exists)
        //                 3. minimum is between [low, high]
        // The proof that the loop will exit: after each iteration either the 'high' decreases
        // or the 'low' increases, so the interval [low, high] will always shrink.
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (num[mid] < num[high])
                // the mininum is in the left part
                high = mid;
            else if (num[mid] > num[high])
                // the mininum is in the right part
                low = mid + 1;
        }

        return num[low];
    }

    public static void main(String[] args) {
        System.out.println(findMin2(new int[]{5, 6, 7, 8, 1, 2, 3, 4}));
        System.out.println(findMin2(new int[]{2, 3, 4, 5, 6, 7, 8, 1, 2}));
        System.out.println(findMin(new int[]{8, 0, 2, 3, 4, 5, 6, 7}));
        System.out.println(findMin(new int[]{0, 2, 3, 4, 5, 6, 7}));
    }
}
