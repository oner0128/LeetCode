package medium;

import java.util.*;

/**
 * Created by rrr on 2017/4/19.
 * 49. Group Anagrams
 * Given an array of strings, group anagrams together.
 * <p>
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * <p>
 * [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note: All inputs will be in lower-case.
 */
public class GroupAnagrams {
    //LeetCode解法
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs==null||strs.length==0)return new ArrayList<>(new ArrayList<>());
        Map<String,List<String>>map=new HashMap<>();
        for (String s:strs){
            char[]ca=s.toCharArray();
            Arrays.sort(ca);
            String key=String.valueOf(ca);
            if (!map.containsKey(key))map.put(key,new ArrayList<>());
             map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "tea", "atea", "bat"};
        System.out.println(new GroupAnagrams().groupAnagrams(strs));
        String[] strs2 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new GroupAnagrams().groupAnagrams(strs2));
    }
}
