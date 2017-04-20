package medium;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;

/**
 * Created by rrr on 2017/3/6.
 * 15. 3Sum
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> threeSum = new ArrayList<>();
        List<Integer> sum;
        Map<Integer, Integer> twoSum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                twoSum.put(0 - nums[i] - nums[j], i * 10 + j);
            }
        }
        System.out.println(twoSum);
        for (int i = 0; i < nums.length; i++) {
            if (twoSum.containsKey(nums[i])) {
                sum = new ArrayList<>();
                sum.add(nums[i]);
                int carry = twoSum.get(nums[i]);
                sum.add(nums[carry / 10]);
                sum.add(nums[carry % 10]);
                threeSum.add(sum);
                System.out.println("index: " + i + "\t" + carry / 10 + "\t" + carry % 10);
                System.out.println(sum);
            }
        }
        return null;
    }

    //思路：先将nums进行排序，从第一个数开始检测后面的某两位数之和与它相加等于0；
    //当遇到一个正数时结束程序，因为数组经过排序，一个正数加比它大的两数无法等于0；
    //在检测后两位数之和时需增加递进条件删除相同的数。
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> threeSum = new ArrayList<>();
        Arrays.sort(nums);
        System.out.println("After Sorting: " + Arrays.toString(nums));
        int i = 0, head, rear;
        while (i < nums.length - 2)//当只剩两个数时可结束
        {
            if (nums[i]>0)break;
            head = i + 1;
            rear = nums.length - 1;
            while (head < rear) {
                int sum = nums[i] + nums[head] + nums[rear];
                if (sum == 0)
                    threeSum.add(Arrays.asList(nums[i], nums[head], nums[rear]));
                if (sum <= 0) {
                    while (head < rear&&nums[head] == nums[head + 1]  ) head++;
                    head++;
                }
                if (sum >= 0) {
                    while (head < rear&&nums[rear] == nums[rear - 1]) rear--;
                    rear--;
                }
            }
            while (nums[i] == nums[i + 1] && i < nums.length - 2) i++;
            i++;
        }
        return threeSum;
    }
    public static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3) return result;
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length - 2) {
            if(nums[i] > 0) break;
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                if(sum <= 0) while(nums[j] == nums[++j] && j < k);
                if(sum >= 0) while(nums[k--] == nums[k] && j < k);
            }
            while(nums[i] == nums[++i] && i < nums.length - 2);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4, -2};
        int[] nums2 = {0,0,0};
        int[] nums3 = {-2,0,1,1,2};
        System.out.println(threeSum2(nums2));
        System.out.println(threeSum2(nums3));
        System.out.println(threeSum3(nums3));
    }
}
