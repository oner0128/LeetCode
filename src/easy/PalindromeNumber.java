package easy;

/**
 * Created by rrr on 2017/4/21.
 * 9. Palindrome Number
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x<0||(x!=0&&x%10==0))return false;
        int rev=0;
        while (x>rev){
            rev=rev*10+x%10;
            x/= 10;
        }
        return rev==x||x==rev/10;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeNumber().isPalindrome(123321));
    }
}
