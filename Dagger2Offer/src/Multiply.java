/**
 * Created by rrr on 2017/5/10.
 * 题目描述
 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class Multiply {
    public int[] multiply(int[] A) {
        int[]res=new int[A.length];
        if (A==null||A.length==0)return res;
        int left=1,right=1;
        //left
        for (int i = 0; i < A.length; i++) {
            res[i]=left;
            left*=A[i];
        }
        //right
        for (int i = A.length-1; i >=0; i--) {
            res[i]*=right;
            right *=A[i];
        }
        return res;
    }
}
