package easy;

/**
 * Created by rrr on 2017/4/10.
 */
public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] isNotPrime = new boolean[n ];
        int count = 0;
        for (int i = 2; i <=n/2 ; i++) {
            if (!isNotPrime[i])
                for (int j = i *2; j < n; j += i)
                    if (!isNotPrime[j]) isNotPrime[j] = true;
        }
        for (int i = 2; i < isNotPrime.length; i++) {
            if (isNotPrime[i] == false) count++;
        }
        return count;
    }
    //LeetCode解法
    public int countPrimes2(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i <=Math.sqrt(n); i++) {
            if (!notPrime[i]) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }

        return count;
    }
}
