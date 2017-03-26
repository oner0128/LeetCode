/**
 * Created by rrr on 2017/3/26.
 * 41. First Missing Positive
 * Given an unsorted integer array, find the first missing positive integer.

 For example,
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.

 Your algorithm should run in O(n) time and uses constant space.
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        if(n==1){
            if(nums[0]==1)return 2;
            else return 1;
        }
        int firstMiss=0;
        boolean[] miss=new boolean[n];
        for(int i=0;i<n;i++){
            if(nums[i]<1||nums[i]>n)continue;
            miss[nums[i]-1]=true;
        }
        for(int i=0;i<n;i++){
            if(miss[i]==false){firstMiss=i+1;break;}
        }
        if(firstMiss==0)firstMiss=n+1;
        return firstMiss;
    }

    //LeetCode大神解法
    //将当前位置的值和当前位置数组的值不相等的交换，若当前位置数组的值等于当前位置值、小于等于0，大于等于数组长度，直接跳过
    public int firstMissingPositive2(int[] A) {
        int i = 0;
        while(i < A.length){
            if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) i++;
            else if(A[A[i]-1] != A[i]) swap(A, i, A[i]-1);
            else i++;
        }
        i = 0;
        while(i < A.length && A[i] == i+1) i++;
        return i+1;
    }

    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
