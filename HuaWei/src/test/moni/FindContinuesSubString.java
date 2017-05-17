package test.moni;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by rrr on 2017/5/17.
 */
public class FindContinuesSubString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(helper(str));
        }
        scanner.close();
    }

    private static String helper(String str) {
        if (str == null) return "";
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, leftIndex = 0, rightIndex = 0, left = 0, right = 0;
        int max = 0;
        while (i < str.length()) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9' && !map.containsKey(str.charAt(i))) {
                leftIndex = map.isEmpty() ? i : leftIndex;
                rightIndex= map.isEmpty() ? i : rightIndex+1;
                map.put(str.charAt(i), i);
            } else {
                map.clear();
            }
            if (rightIndex - leftIndex > max) {
                left = leftIndex;
                right = rightIndex;
                max = rightIndex - leftIndex;
            }
            i++;
        }
        return str.substring(left, right + 1);
    }
}
