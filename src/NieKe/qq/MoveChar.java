package NieKe.qq;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by rrr on 2017/4/12.
 */
public class MoveChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            char[] word = str.toCharArray();
            int lo = word.length-2, hi = word.length-1;
            while (lo >= 0 && hi >lo) {
                while (hi>0&&word[hi]>=65&&word[hi]<=90)hi--;
                lo=hi;
                while (lo>0&&word[lo]>=97&&word[lo]<=122)lo--;
                if ((word[lo]>=65&&word[lo]<=90)&&(word[hi]>=97&&word[hi]<=122))
                for (int i = lo; i < hi; i++) {
                    char tmp=word[i];
                    word[i]=word[i+1];
                    word[i+1]=tmp;
                }
                lo--;hi--;
            }
            StringBuffer sb=new StringBuffer();
            for (int i = 0; i < word.length ; i++) {
                sb.append(word[i]);
            }
            System.out.println(sb.toString());
        }
    }
}
