import java.util.Arrays;

/**
 * Created by rrr on 2017/3/24.
 * 283. Move Zeroes
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 Note:
 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.

 解法：1.两点法，当nums[i]=0时需要与后边的nums[j]！=0交换
 2.//插入法，当nums[i]!=0时向前插入到前一个非零数的后边

 运行时间：解法1  2ms
 解法2  64ms
 */
public class MoveZeros {
    //两点法，当nums[i]=0时需要与后边的nums[j]！=0交换
    public static void moveZeroes(int[] nums) {
        int head=0;
        int count=1;
        while (head<nums.length&&count<nums.length){
            if (nums[head]==0&&nums[count]!=0){exchange(nums,head,count);
            head++;count++;}
            while (head<nums.length&&nums[head]!=0)count=++head;
            while (count<nums.length&&nums[count]==0)count++;
        }
    }
    public static void exchange(int[] nums,int i,int j) {
        int tmp;
        tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    //插入法，当nums[i]!=0时向前插入到前一个非零数的后边
    public static void moveZeroes2(int[] nums) {
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i]==0)continue;
            for (int j = i; j > 0; j--) {
                if (nums[j-1]==0)exchange(nums,j,j-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums={0,1,0,3,12};
        System.out.println(Arrays.toString(nums));
        moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
        int[] nums2={1,10,1,0,3,12,0};
        System.out.println(Arrays.toString(nums2));
        moveZeroes2(nums2);
        System.out.println(Arrays.toString(nums2));
        int[] nums3={0,0,1,10,1,0,3,0,12,0};
        System.out.println(Arrays.toString(nums3));
        moveZeroes2(nums3);
        System.out.println(Arrays.toString(nums3));
    }
}
