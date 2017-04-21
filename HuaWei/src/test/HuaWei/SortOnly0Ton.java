package test.HuaWei;

import java.util.Arrays;

/**
 * Created by rrr on 2017/4/21.
 */
public class SortOnly0Ton {

        /**
         * 交换数组里n和0的位置
         *
         * @param array
         *            数组
         * @param len
         *            数组长度
         * @param n
         *            和0交换的数
         */
        // 不要修改以下函数内容
        public static void swapWithZero(int[] array, int len, int n) {
            int tmp=array[0];
            array[0]=array[n];array[n]=tmp;
        }
        // 不要修改以上函数内容


        /**
         * 通过调用swapWithZero方法来排
         *
         * @param array
         *            存储有[0,n)的数组
         * @param len
         *            数组长度
         */
        public static void sort(int[] array, int len) {
            int i=0;
            while (true){
                for (int j = 0; j < len; j++) {
                    if (j!=array[j])break;
                    if (j==len-1)return;
                }
                i=i%len;
                if (array[i]!=i)swapWithZero(array,len,array[i++]);
                else i++;
            }
        }

    public static void main(String[] args) {
        int[]array={8,6,4,3,2,5,1,0,7};
       sort(array,9);
        System.out.println(Arrays.toString(array));
    }
}
