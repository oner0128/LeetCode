/**
 * Created by rrr on 2017/5/5.
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum_Solution {
    public static int MoreThanHalfNum_Solution(int [] array) {
        if (array==null||array.length==0)return 0;
        int moreHalfNum=array[0];
        int count=0;
        int i=0;
        while (i<array.length){
            if (moreHalfNum==array[i])
                count++;
            else {moreHalfNum=count==0?array[i]:moreHalfNum;count=count>0?count-1:0;}
            i++;
        }
        return count>0?moreHalfNum:0;
    }

    public static void main(String[] args) {
        System.out.println(MoreThanHalfNum_Solution(new int[]{1,2,3,2,2,2,5,4,2}));
        System.out.println(MoreThanHalfNum_Solution(new int[]{2,2,2,2,2,1,3,4,5}));
        System.out.println(MoreThanHalfNum_Solution(new int[]{2,2,2,2,1,3,4,5}));
    }
}
