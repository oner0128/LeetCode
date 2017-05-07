/**
 * Created by rrr on 2017/5/6.
 * 题目描述
 * 把只包含素因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class GetUglyNumber_Solution {
    public static int GetUglyNumber_Solution(int index) {
        if (index <= 0) return 0;
        int[] ugly = new int[index + 1];
        ugly[1] = 1;
        int ugly2 = 1, ugly3 = 1, ugly5 = 1;
        int nextUgly = 2;
        while (nextUgly < index+1) {
            int min = min(ugly[ugly2] * 2, ugly[ugly3] * 3, ugly[ugly5] * 5);
            ugly[nextUgly] = min;
            while (ugly[ugly2] * 2<=ugly[nextUgly])ugly2++;
            while (ugly[ugly3] * 3<=ugly[nextUgly])ugly3++;
            while (ugly[ugly5] * 5<=ugly[nextUgly])ugly5++;
            nextUgly++;
        }
        return ugly[index];
    }

    private static int min(int one, int two, int three) {
        return one < two ? (one < three ? one : three) : (two < three ? two : three);
    }

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(3));
    }
}
