package easy;

/**
 * Created by hrong on 2017/1/8.
 * 461. Hamming Distance（两个数在Bit位中不相同的位数的个数）
 * 提示：位操作
 * 思路：利用异或位操作使得两个不相同位数置为1，然后求余计数，所有的计算操作都可以使用位操作。
 */
public class HammingDistance {
    public static int hammingDistance(int x, int y) {
        int tmp = x ^ y;
        System.out.println("异或结果比特值：" + Integer.toBinaryString(tmp));
        int differentBits = 0;
        int mod;
        while (tmp > 0) {
            mod = tmp & 0x1;
            if (mod == 1) differentBits++;
            tmp = tmp >> 1;
        }
        return differentBits;
    }

    public static void main(String[] args) {
        int x = 15123123, y = 2123123123;
        System.out.println(x + " and " + y + " 's Hamming Distance is :" + hammingDistance(x, y));
    }
}
