/**
 * Created by rrr on 2017/5/5.
 */
public class FindGreatestSumOfSubArray {
    public static int FindGreatestSumOfSubArray(int[] array) {
        if (array==null||array.length==0)return 0;
        int max=array[0];
        int sum=0;
        for (int n:array){
            sum=sum>0?sum+n:n;
            max=Math.max(sum,max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(FindGreatestSumOfSubArray(new int[]{-2,-8,-1,-5,-9}));
        System.out.println(FindGreatestSumOfSubArray(new int[]{1,-2,3,10,-4,7,2,-5}));
    }
}
