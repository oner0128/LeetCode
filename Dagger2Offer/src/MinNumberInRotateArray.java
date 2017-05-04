/**
 * Created by rrr on 2017/5/3.
 * 题目描述
 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MinNumberInRotateArray {
    public static int minNumberInRotateArray(int [] array) {
        if (array.length==0)return 0;
        int lo=0,hi=array.length-1;
        while (lo<hi){
            int mid=lo+(hi-lo)/2;
            if (array[hi]>array[mid])hi=mid;
            else if (array[hi]<array[mid])lo=mid+1;
            else return helper(array);
        }
        return array[lo];
    }

    private static int helper(int[] array) {
        int min=array[0];
        for(int n:array)if (min>n)min=n;
        return min;
    }

    public static void main(String[] args) {
        System.out.println(minNumberInRotateArray(new int[]{3,4,5,1,2}));
        System.out.println(minNumberInRotateArray(new int[]{2,3,4,5,1}));
        System.out.println(minNumberInRotateArray(new int[]{1,2,3,4,5}));
        System.out.println(minNumberInRotateArray(new int[]{5,1,2,3,4}));
        System.out.println(minNumberInRotateArray(new int[]{1,1,1,1,1,1,1,1,1,0,1}));
    }
}
