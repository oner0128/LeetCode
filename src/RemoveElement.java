import java.util.Arrays;

/**
 * Created by rrr on 2017/2/14.
 */
public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        if (nums.length<1)return 0;
        int length=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=val)nums[length++]=nums[i];
        }
        return length;
    }
    public static int removeElement2(int[] nums, int val) {
        int l = nums.length;
        for (int i=0; i<l; i++) {
            if (nums[i] == val) {
                nums[i--] = nums[l-- -1];//题目提示可以改变数组的元素排列
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums={3,2,1,3};
        System.out.println(Arrays.toString(nums));
        System.out.println(removeElement2(nums,3));
        int[] nums2={5};
        System.out.println(Arrays.toString(nums2));
        System.out.println(removeElement2(nums2,5));
    }
}
