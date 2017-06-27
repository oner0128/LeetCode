import java.util.Scanner;

/**
 * Created by rrr on 2017/6/27.相当于求最长回文子串
 * 题目描述
 Catcher 是MCA国的情报员，
 他工作时发现敌国会用一些对称的密码进行通信，
 比如像这些ABBA，ABA，A，123321，
 但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
 */
public class PasswordCutOut {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String password=scanner.next();
            int maxLen=cutOutPassword(password);
            System.out.println(maxLen);
        }
    }

    private static int cutOutPassword(String password) {
        if (password==null)return 0;
        int maxLen=1;
        for (int i = 0; i < password.length(); i++) {
            int odd=isPalindrome(password,i-1,i+1)+1;
            int even=isPalindrome(password,i,i+1);
            maxLen=Math.max(maxLen,Math.max(odd,even));
        }
        return maxLen;
    }

    private static int isPalindrome(String password, int lo, int hi) {
        int len=0;
        while (lo>=0&&hi<password.length()&&lo<hi){
            if (password.charAt(lo)!=password.charAt(hi))return len;
            len+=2;lo--;hi++;
        }
        return len;
    }
}
