package base;

import java.util.Random;

/**
 * Created by rrr on 2017/2/14.
 */
public class BinarySearch {
    public static int binarySearch(int[] nums,int target){
        int lo = 0, hi = nums.length -1;
        int mid =0;
        while (lo <=hi) {
            mid = (lo + hi) / 2;
            if (nums[mid] > target) {
                hi=mid-1;
            } else if (nums[mid] < target){
                lo=mid+1;
            }else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Random().nextInt(5));
        StringBuilder stringBuilder=new StringBuilder("12345");
        System.out.println(stringBuilder.insert(2,"a").toString());
    }
}
