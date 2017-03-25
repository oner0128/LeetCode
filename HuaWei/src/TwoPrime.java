import java.util.Scanner;

/**
 * Created by rrr on 2017/3/25.
 * 题目描述
 * 任意一个偶数（大于2）都可以由2个素数组成，组成偶数的2个素数有很多种情况，本题目要求输出组成指定偶数的两个素数差值最小的素数对
 * 输入例子:
 * 20
 * <p>
 * 输出例子:
 * 7
 * 13
 */
public class TwoPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int even = scanner.nextInt();
            twoPrime(even);
        }
        scanner.close();
    }

    public static void twoPrime(int nums) {
        boolean[] isNotPrime=new boolean[nums];int[] results = new int[2];
        int n= (int) Math.sqrt(nums);
        isNotPrime[0]= isNotPrime[1]=true;
        for (int i = 0; i <= n; i++) {
            if (!isNotPrime[i]) for (int j = 2*i; j < nums; j+=i) {
                isNotPrime[j]=true;
            }
        }
        if (!isNotPrime[nums/2]){
            System.out.println(nums/2);System.out.println(nums/2);
            return;
        }
        int first=nums/2-1;int second=first+1;
       while (first>=0&&second<nums){
           while (isNotPrime[first])first--;
           while (isNotPrime[second])second++;
           int tmp=first+second;
           if (tmp==nums)break;
           if (tmp<nums)second++;
           else first--;
       }
        System.out.println(first);System.out.println(second);
    }
}
