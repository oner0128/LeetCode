package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrr on 2017/4/20.
 * 383. Ransom Note
 * Given an arbitrary ransom note string and
 * another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines ;
 * otherwise, it will return false.
 Each letter in the magazine string can only be used once in your ransom note.
 Note:
 You may assume that both strings contain only lowercase letters.
 canConstruct("a", "b") -> false
 canConstruct("aa", "ab") -> false
 canConstruct("aa", "aab") -> true
 */
public class RansomNote {
    //66ms HashMap
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        char[] note = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();
        for (char c : mag) map.put(c, map.getOrDefault(c, 0) + 1);
        for (char c : note)
            if (!map.containsKey(c)) return false;
            else if (map.get(c)<=0)return false;
            else map.put(c,map.get(c)-1);
        return true;
    }
    //13ms 桶
    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] bucketNote=new int[26];
        int[] bucketMag=new int[26];
        char[] note = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();
        for (char c : mag) bucketMag[c-'a']++;
        for (char c : note)bucketNote[c-'a']++;
        for (int i = 0; i < 26; i++)
            if (bucketMag[i]<bucketNote[i])return false;//当bucketMag[i]<bucketNote[i]说明该字符mag无或不足
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new RansomNote().canConstruct2("eg","efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj"));
    }
}
