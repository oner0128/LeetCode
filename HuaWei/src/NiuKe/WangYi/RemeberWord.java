package NiuKe.WangYi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by rrr on 2017/4/12.
 */
public class RemeberWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nums=scanner.nextLine().split(" ");
        int m = Integer.parseInt(nums[0]);
        int n = Integer.parseInt(nums[1]);
        String[] words = new String[m];
//        String[] words = scanner.nextLine().split(" ");
        for (int i = 0; i < m; i++) {
            words[i]=scanner.next();
        }
        String[] writes = new String[n];
//        String[] writes = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            writes[i]=scanner.next();
        }
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        int score = 0;
        for (String word : writes) {
            if (set.contains(word))score+=word.length()*word.length();
            set.remove(word);
        }
        System.out.println(score);
    }
}
