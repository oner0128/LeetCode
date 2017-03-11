import java.util.Arrays;

/**
 * Created by rrr on 2017/3/9.
 * 题目：元素按奇偶排序
 给定一个数组input[]，如果数组长度n为奇数，则将数组中最大的元素放到 output[]数组最中间的位置，
 如果数组长度n为偶数，则将数组中最大的元素放到 output[]数组中间两个位置偏右的那个位置上，
 然后再按从大到小的顺序，依次在最大元素放置的那个位置的两边，按照一左一右的顺序，依次存放剩下的数。
 例如：input[] = {3, 6, 1, 9, 7}
 output[] ={3, 7, 9, 6, 1};
 input[] = {3, 6, 1, 9, 7,8}
 output[] = {1, 6, 8, 9, 7, 3}
 */
public class SortedByLeftRight {
    public static int[] sortedByLeftRight(int[]nums){
        int[] result=new int[nums.length];
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int index=nums.length/2;
        result[index--]=nums[nums.length-1];
        for (int i = nums.length-2; i >= 0; i=i-2) {
            result[index]=nums[i];
            index--;
        }index=nums.length/2+1;
        for (int i = nums.length-3; i >= 0; i=i-2) {
            result[index]=nums[i];
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[]nums={3, 6, 1, 9, 7,2,10,4};
        int[]nums2={3, 6, 1, 9, 7,8,98,10,2};
        System.out.println(Arrays.toString(sortedByLeftRight(nums)));
        System.out.println(Arrays.toString(sortedByLeftRight(nums2)));

    }
}
