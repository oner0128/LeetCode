package easy;

/**
 * Created by rrr on 2017/4/21.
 */
public class ReverseInteger {
    //LeetCode解法
    public int reverse(int x){
        int result=0;
        while (x!=0){
            int tail=x%10;
            int newResult=result*10+tail;
            if ((newResult-tail)/10!=result)return 0;
            result=newResult;
            x/=10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(Integer.MAX_VALUE));
    }
}
