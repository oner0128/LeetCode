package medium;

import java.util.*;

/**
 * Created by rrr on 2017/7/8.
 * 267.Palindrome Permutation II
 * <p>
 * Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.
 * <p>
 * For example:
 * <p>
 * Given s = "aabb", return ["abba", "baab"].
 * <p>
 * Given s = "abc", return [].
 * <p>
 * Hint:
 * <p>
 * If a palindromic permutation exists, we just need to generate the first half of the string.
 * To generate all distinct permutations of a (half of) string, use a similar approach from: Permutations II or Next Permutation.
 */
public class PalindromePermutationII {
    public static List<String> generatePalindromes(String s) {
        List<String> res = new LinkedList<>();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Character> characters = new LinkedList<>();
        int odd = 0;
        Character oddChar = null;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                odd++;
                oddChar = entry.getKey();
            }
            if (odd > 1) return res; //can't PermutePalindrome
            for (int i = 0; i < entry.getValue() / 2; i++) {
                characters.add(entry.getKey());
            }
        }
        boolean[] used = new boolean[characters.size()];
        backtrace(characters, res, used, new LinkedList<Character>(),oddChar);
        return res;
    }

    private static void backtrace(List<Character> characters, List<String> res, boolean[] used, LinkedList<Character> characterLinkedList, Character oddChar) {
        if (characterLinkedList.size() == characters.size()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (char c : characterLinkedList) stringBuilder.append(c);
            String str=stringBuilder.toString();
            stringBuilder.reverse().append(str);
            if (oddChar!=null)stringBuilder.insert(characters.size(),oddChar);
            res.add(stringBuilder.toString());
        } else for (int i = 0; i < characters.size(); i++) {
            if (used[i] || i > 0 && characters.get(i) == characters.get(i - 1) && !used[i - 1]) continue;
            used[i] = true;
            characterLinkedList.add(characters.get(i));
            backtrace(characters, res, used, characterLinkedList, oddChar);
            used[i] = false;
            characterLinkedList.remove(characterLinkedList.size() - 1);
        }
    }
    public static List<String> generatePalindromes2(String s) {
        int odd = 0;
        String mid = "";
        List<String> res = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        // step 1. build character count map and count odds
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
            odd += map.get(c) % 2 != 0 ? 1 : -1;
        }

        // cannot form any palindromic string
        if (odd > 1) return res;

        // step 2. add half count of each character to list
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();

            if (val % 2 != 0) mid += key;

            for (int i = 0; i < val / 2; i++) list.add(key);
        }

        // step 3. generate all the permutations
        getPerm(list, mid, new boolean[list.size()], new StringBuilder(), res);

        return res;
    }

    // generate all unique permutation from list
    private static void getPerm(List<Character> list, String mid, boolean[] used, StringBuilder sb, List<String> res) {
        if (sb.length() == list.size()) {
            // form the palindromic string
            res.add(sb.toString() + mid + sb.reverse().toString());
            sb.reverse();
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            // avoid duplication
            if (i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1]) continue;

            if (!used[i]) {
                used[i] = true; sb.append(list.get(i));
                // recursion
                getPerm(list, mid, used, sb, res);
                // backtracking
                used[i] = false; sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    public static void main(String[] args) {
        generatePalindromes("aabbc");
    }
}
