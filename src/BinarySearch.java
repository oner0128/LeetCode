/**
 * Created by rrr on 2017/2/14.
 */
public class BinarySearch {
    public static int binarySearch(int[] nums,int target){
        int begin = 0, end = nums.length -1;
        int index =0;
        while (begin <=end) {
            index = (begin + end) / 2;
            if (nums[index] > target) {
                end=index;
            } else if (nums[index] < target){
                begin=index;
            }else return index;
        }
        return index;
    }
}
