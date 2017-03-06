import java.util.Arrays;
import java.util.Objects;

/**
 * Created by hrong on 2017/1/9.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println((1 + 2.12) / 2);
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE + 2));
        int[][] nums=new int[2][4];
        System.out.println(nums.length);
        System.out.println(nums[0].length);
        int[] n={1,10,100};int i=0;n[i++]=n[i]+1;
        System.out.println(Arrays.toString(n));
        System.out.println(i);
        int[] n1=new int[5];
        System.out.println(Arrays.toString(n1));
//        Double.hashCode();
        int[] n2={1,2,1};int j=0;n2[j++]=0;
        System.out.println(Arrays.toString(n2));
        i=0;
        System.out.println(n2[i++]==n2[i]);//n2[1]?=n2[2]
        i=0;
        System.out.println(n2[i]==n2[i++]);//n2[1]?=n2[1]
    }
}
