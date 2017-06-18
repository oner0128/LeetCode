package easy;

/**
 * Created by rrr on 2017/6/18.
 * 278. First Bad Version
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

 Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

 You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */
public class FirstBadVersion {
    //26ms找到当前mid为好的版本，下一个为坏的版本
    public int firstBadVersion(int n) {
        if (n<=0)return 0;
        int lo=1,hi=n;
        int mid;
        while (lo<=hi){
            mid=lo+(hi-lo)/2;
            boolean isBad=isBadVersion(mid);
            if (isBad==false&&(mid+1)<=n&&isBadVersion(mid+1)==true)return mid+1;
            else if (isBad==true)hi=mid-1;
            else lo=mid+1;
        }
        return lo;
    }
    //LeetCode解法 17 ms
    public int firstBadVersion2(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end-start) / 2;
            if (!isBadVersion(mid)) start = mid + 1;
            else end = mid;
        }
        return start;
    }
    private boolean isBadVersion(int mid) {
        return false;
    }
}
