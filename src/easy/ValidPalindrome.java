package easy;

/**
 * Created by rrr on 2017/4/19.
 * 125. Valid Palindrome
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.
 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.
 For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        //34ms
        char[]chars=s.toLowerCase().replaceAll("[^a-z0-9]","").toCharArray();
        int i=0,j=chars.length-1;
        while (i<j) if (chars[i++]!=chars[j--])return false;
        return true;
    }
    //11ms
    public boolean isPalindrome2(String s) {
        String ss="abcdefghijklmnopqrstuvwxyz0123456789";
        char[]chars=s.trim().toLowerCase().toCharArray();
        int i=0,j=chars.length-1;
        while (i<j){
            while (i<j&&(ss.indexOf(chars[i])==-1))i++;
            while (i<j&&(ss.indexOf(chars[j])==-1))j--;
            if (chars[i++]!=chars[j--])return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome2("A man, a plan, ac ccanal: Panama"));
    }
}
