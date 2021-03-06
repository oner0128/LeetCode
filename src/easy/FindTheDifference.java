package easy;

/**
 * Created by rrr on 2017/4/10.
 * 389. Find the Difference
 * Given two strings s and t which consist of only lowercase letters.

 String t is generated by random shuffling string s and then add one more letter at a random position.

 Find the letter that was added in t.

 Example:

 Input:
 s = "abcd"
 t = "abcde"

 Output:
 e

 Explanation:
 'e' is the letter that was added.
 */
public class FindTheDifference {
    //bucket
    public char findTheDifference(String s, String t) {
        int[]bucket1=new int[128];int[]bucket2=new int[128];
        for (char c:s.toCharArray())bucket1[c]+=1;
        for (char c:t.toCharArray())bucket2[c]+=1;
        for (int i = 0; i < bucket1.length; i++) {
            if (bucket2[i]-bucket1[i]==1)return (char) i;
        }
        return ' ';
    }
    //Bit Manipulation
    public char findTheDifference2(String s, String t) {
        int sum=0;
        for (char c:s.toCharArray())sum^=c;
        for (char c:t.toCharArray())sum^=c;
        return (char)sum;
    }
}
