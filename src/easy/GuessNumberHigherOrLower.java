package easy;

import java.util.Random;

/**
 * Created by rrr on 2017/6/18.
 * 374. Guess Number Higher or Lower
 * We are playing the Guess Game. The game is as follows:

 I pick a number from 1 to n. You have to guess which number I picked.

 Every time you guess wrong, I'll tell you whether the number is higher or lower.

 You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

 -1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
 Example:
 n = 10, I pick 6.

 Return 6.
 */
public class GuessNumberHigherOrLower {
//    The key point is to read the problem carefully.
//-1 : My number is lower
//1 : My number is higher
//0 : Congrats! You got it!
//
//    Here "My" means the number which is given for you to guess not the number you put into guess(int num).
    public static int guessNumber(int n) {
        int lo=1,hi=n;
        int Num=lo+(hi-lo)/2;
        while (lo<=hi){
            Num=lo+(hi-lo)/2;
            if (guess(Num)==0)break;
            else if (guess(Num)==-1)hi=Num-1;//
            else lo=Num+1;
        }
        return Num;
    }
    static int guess(int n){
        int pick=6;
        if (n==pick)return 0;
        if (n>pick)return 1;
        else return -1;
    }

    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }
}
