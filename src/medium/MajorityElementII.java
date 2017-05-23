package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by rrr on 2017/5/19.
 * 229. Majority Element II
 * Given an integer array of size n,
 * find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer>res=new ArrayList<>();
        if (nums==null||nums.length==0)return res;
        int number1=nums[0],number2=nums[0],count1=0,count2=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==number1)count1++;
            else if (nums[i]==number2)count2++;
            else if (count1==0){number1=nums[i];count1=1;}
            else if (count2==0){number2=nums[i];count2=1;}
            else {count1--;count2--;}
        }
        count1=0;count2=0;
        for (int i = 0; i < nums.length; i++) {
            if (number1==nums[i])count1++;
            else if (number2==nums[i])count2++;
        }
        if (count1>nums.length/3)res.add(number1);
        if (count2>nums.length/3)res.add(number2);
        return res;
    }
}
