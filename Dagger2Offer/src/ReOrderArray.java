import java.util.Arrays;

/**
 * Created by rrr on 2017/5/3.
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    public void reOrderArray(int[] array) {
        int[] help = new int[array.length];
        int odd = 0;
        for (int n : array) {
            if ((n & 1) == 1) help[odd++] = n;
        }
        for (int n : array) {
            if ((n & 1) == 0) help[odd++] = n;
        }
        odd = 0;
        for (int n : help) {
            array[odd++] = n;
        }
    }

    public void reOrderArray2(int[] array) {
        int even = array.length - 2;
        while ( 0<= even) {
            if (array[even] % 2 == 0) {
                int i = even;
                while (i < array.length - 1 && array[i] % 2 == 0 && array[i + 1] % 2 == 1) {
                    array[i] ^= array[i + 1];
                    array[i + 1] ^= array[i];
                    array[i] ^= array[i + 1];
                    i++;
                }
            }
            even--;
        }
    }

    public static void main(String[] args) {
        int[] n = {2,4,6,1,3,5,7};
        new ReOrderArray().reOrderArray2(n);
        System.out.println(Arrays.toString(n));
    }
}
