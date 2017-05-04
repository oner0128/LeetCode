/**
 * Created by rrr on 2017/5/3.
 * 题目描述
 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Power {
    public double Power(double base, int exponent) {
        if (base==0)return 0;
        if (base==1||exponent==0)return 1;
        long m=exponent>0?exponent:-(long)exponent;
        double ans=1;
        while (m!=0){
            if (m%2==1)ans*=base;
            base*=base;
            m>>=1;
        }
        return exponent>0?ans:1/ans;
    }

    public static void main(String[] args) {
        System.out.println(new Power().Power(5,13));
    }
}
