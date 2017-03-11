/**
 * Created by rrr on 2017/3/11.
 * 88. Merge Sorted Array
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length=m+n;
        while (n>0&&m>0){
            if (nums1[m-1]>nums2[n-1])nums1[--length]=nums1[--m];
            else nums1[--length]=nums2[--n];
        }
        while (n>0)nums1[--length]=nums2[--n];
    }
public void merge2(int[] A, int m, int[] B, int n) {
        while(n>0)A[m+n-1]=(m==0||B[n-1]>A[m-1])?B[--n]:A[--m];}
    public static void main(String[] args) {

    }
}
