package easy;

import java.util.*;

/**
 * Created by rrr on 2017/4/10.
 * 500. Keyboard Row
 * Given a List of words, return the words
 * that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 * Example 1:
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 * Note:
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 */
public class KeyboardRow {
    public static String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        boolean one, two, three;
        for (String word : words) {
            char[] c = word.toLowerCase().toCharArray();
            one = two = three = false;
            for (char cc : c) {
                if (cc == 'q' || cc == 'w' || cc == 'e' || cc == 'r' || cc == 't' || cc == 'y' || cc == 'u' || cc == 'i' || cc == 'o' || cc == 'p')
                    one = true;
                else if (cc == 'a' || cc == 's' || cc == 'd' || cc == 'f' || cc == 'g' || cc == 'h' || cc == 'j' || cc == 'k' || cc == 'l')
                    two = true;
                else if (cc == 'z' || cc == 'x' || cc == 'c' || cc == 'v' || cc == 'b' || cc == 'n' || cc == 'm')
                    three = true;
                if (one && two || three && two || one && three) break;
            }
            if (one && two || three && two || one && three) continue;
            list.add(word);
        }
        return list.toArray(new String[0]);
    }

    //Regex
    public static String[] findWords2(String[] words) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (!word.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")) continue;
            list.add(word);
        }
        return list.toArray(new String[0]);
    }

    //HashTable
    public static String[] findWords3(String[] words) {
        List<String> list = new ArrayList<>();
        String[] strings = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            for (Character c : strings[i].toCharArray()) {
                map.put(c, i+1);
            }
        }
        for (String word : words) {
            char[]c=word.toLowerCase().toCharArray();
            int i=1;
            for (; i < c.length; i++) {
                if (map.get(c[i])==map.get(c[i-1]))continue;
                break;
            }
            if (i==c.length)list.add(word);
        }
        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(Arrays.toString(words));
        System.out.println(Arrays.toString(findWords2(words)));
        System.out.println(Arrays.toString(findWords3(words)));
        String[] words2 = {"Hello", "Peace"};
        System.out.println(Arrays.toString(words2));
        System.out.println(Arrays.toString(findWords2(words2)));
        System.out.println(Arrays.toString(findWords3(words2)));
        String[] words3 = {"Hello", "Dad", "Peace"};
        System.out.println(Arrays.toString(words3));
        System.out.println(Arrays.toString(findWords2(words3)));
        System.out.println(Arrays.toString(findWords3(words3)));
    }
}
