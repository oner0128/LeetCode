/**
 * Created by rrr on 2017/5/5.
 * 题目描述
 统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfK {
    public static int GetNumberOfK(int [] array , int k) {
        if (array==null||array.length==0)return 0;
        int lo=0,hi=array.length-1;
        int mid=lo+(hi-lo)/2;
        while (lo<=hi){
            mid=lo+(hi-lo)/2;
            if (array[mid]==k)break;
            if (array[mid]>k)hi=mid-1;
            else lo=mid+1;
        }
        if (array[mid]!=k)return 0;
        int index=mid;
        int head=-1,end=-1;
        //left index
        lo=0;hi=index;
        while (lo<=hi){
            mid=lo+(hi-lo)/2;
            if (array[mid]!=k&&array[mid+1]==k)break;
            if (array[mid]==k)hi=mid-1;
            else lo=mid+1;
        }
        if (array[mid]!=k&&array[mid+1]==k)head=mid+1;
        else head=lo;


        //right index
        lo=index;hi=array.length-1;
        while (lo<=hi){
            mid=lo+(hi-lo)/2;
            if (array[mid]!=k&&array[mid-1]==k)break;
            if (array[mid]==k)lo=mid+1;
            else hi=mid-1;
        }
        if (array[mid]!=k&&array[mid-1]==k)end=mid-1;
        else end=hi;
        return end-head+1;
    }

    public static void main(String[] args) {
//        System.out.println(GetNumberOfK(new int[]{1,2,3,3,3,3,4,5},3));
//        System.out.println(GetNumberOfK(new int[]{3,3,3,3,3,3,4,5},3));
        System.out.println(GetNumberOfK(new int[]{3},3));
    }
}

