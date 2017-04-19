package medium;

import java.util.*;

/**
 * Created by rrr on 2017/3/23.
 * 18. 4Sum
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 */
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        HashMap<Integer, Integer> threeSumTarget = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            threeSumTarget.put(target - nums[i], nums[i]);
        }
        int i = 0;
        while (i < nums.length - 2) {
            int head = i + 1;
            int end = nums.length - 1;
            while (head < end) {
                int sum = nums[i] + nums[head] + nums[end];
                if (threeSumTarget.containsKey(sum)) {
                    System.out.println(threeSumTarget.get(sum));
//                    results.add(new ArrayList<>(Arrays.asList(nums[i], nums[head], nums[end])));
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) i++;
        }
        return results;
    }
    //25ms
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        if (nums == null || len < 4)
            return res;

        Arrays.sort(nums);

        int max = nums[len - 1];
        if (4 * nums[0] > target || 4 * max < target)
            return res;

        int i, z;
        for (i = 0; i < len; i++) {
            z = nums[i];
            if (i > 0 && z == nums[i - 1])// avoid duplicate
                continue;
            if (z + 3 * max < target) // z is too small
                continue;
            if (4 * z > target) // z is too large
                break;
            if (4 * z == target) { // z is the boundary
                if (i + 3 < len && nums[i + 3] == z)
                    res.add(Arrays.asList(z, z, z, z));
                break;
            }

            threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);
        }

        return res;
    }

    /*
     * Find all possible distinguished three numbers adding up to the target
     * in sorted array nums[] between indices low and high. If there are,
     * add all of them into the ArrayList fourSumList, using
     * fourSumList.add(Arrays.asList(z1, the three numbers))
     */
    public void threeSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
                                   int z1) {
        if (low + 1 >= high)
            return;

        int max = nums[high];
        if (3 * nums[low] > target || 3 * max < target)
            return;

        int i, z;
        for (i = low; i < high - 1; i++) {
            z = nums[i];
            if (i > low && z == nums[i - 1]) // avoid duplicate
                continue;
            if (z + 2 * max < target) // z is too small
                continue;

            if (3 * z > target) // z is too large
                break;

            if (3 * z == target) { // z is the boundary
                if (i + 1 < high && nums[i + 2] == z)
                    fourSumList.add(Arrays.asList(z1, z, z, z));
                break;
            }

            twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, z1, z);
        }

    }

    /*
     * Find all possible distinguished two numbers adding up to the target
     * in sorted array nums[] between indices low and high. If there are,
     * add all of them into the ArrayList fourSumList, using
     * fourSumList.add(Arrays.asList(z1, z2, the two numbers))
     */
    public void twoSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
                                 int z1, int z2) {

        if (low >= high)
            return;

        if (2 * nums[low] > target || 2 * nums[high] < target)
            return;

        int i = low, j = high, sum, x;
        while (i < j) {
            sum = nums[i] + nums[j];
            if (sum == target) {
                fourSumList.add(Arrays.asList(z1, z2, nums[i], nums[j]));

                x = nums[i];
                while (++i < j && x == nums[i]) // avoid duplicate
                    ;
                x = nums[j];
                while (i < --j && x == nums[j]) // avoid duplicate
                    ;
            }
            if (sum < target)
                i++;
            if (sum > target)
                j--;
        }
        return;
    }
    //79ms
    public List<List<Integer>> fourSum3(int[] num, int target) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if(num.length<4)return ans;
        Arrays.sort(num);
        for(int i=0; i<num.length-3; i++){
            if(i>0&&num[i]==num[i-1])continue;
            for(int j=i+1; j<num.length-2; j++){
                if(j>i+1&&num[j]==num[j-1])continue;
                int low=j+1, high=num.length-1;
                while(low<high){
                    int sum=num[i]+num[j]+num[low]+num[high];
                    if(sum==target){
                        ans.add(Arrays.asList(num[i], num[j], num[low], num[high]));
                        while(low<high&&num[low]==num[low+1])low++;
                        while(low<high&&num[high]==num[high-1])high--;
                        low++;
                        high--;
                    }
                    else if(sum<target)low++;
                    else high--;
                }
            }
        }
        return ans;
    }
}
