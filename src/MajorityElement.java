import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrr on 2017/3/24.
 * 169. Majority Element
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *You may assume that the array is non-empty and the majority element always exist in the array.
 * 思路一：排序后返回nums[len/2]  O（nlogn）
 * 思路二：利用HashMap遍历一次，若有键的值大于len/2;则返回该值 时间O（n） 空间复杂度O（n）
 * 思路三：Moore voting algorithm  时间O（n） 空间复杂度O（1）
 */
public class MajorityElement {
    //思路二
    public static int majorityElement(int[] nums) {
        if (nums.length<=1)return nums.length==0?0:nums[0];
        Map<Integer, Integer> element = new HashMap<>();
        Map<Integer, Integer> maxs = new HashMap<>();
        int max = 0;
        for (int i :nums) {
            if (element.containsKey(i)) {
                int tmp=element.get(i) + 1;
                element.put(i,tmp);
                if (max<tmp){
                    max=tmp;
                    maxs.put(max,i);}
            } else element.put(i, 1);
        }
        return maxs.get(max);
    }
    //思路二
    public static int majorityElement2(int[] nums) {
        Map<Integer, Integer> element = new HashMap<>();
        int result=0;
        for (int i :nums) {
            if (element.containsKey(i)) {
                int tmp=element.get(i) + 1;
                element.put(i,tmp);
                if (tmp>nums.length/2){
                    result=i;break;}
            } else element.put(i, 1);
        }
        return result;
    }
    //Moore voting algorithm
    public static int majorityElement3(int[] num) {

        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;

        }
        return major;
    }
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 0};
        System.out.println(Arrays.toString(nums));
        System.out.println(majorityElement3(nums));
        int[] nums3 = {7,6,6,6,7,7,1,6};
        System.out.println(Arrays.toString(nums3));
        System.out.println(majorityElement2(nums3));

    }
}
