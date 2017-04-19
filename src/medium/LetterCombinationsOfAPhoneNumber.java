package medium;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;

/**
 * Created by rrr on 2017/4/19.
 * 17.Letter Combinations of a Phone Number
 * Given a digit string, return all possible letter combinations that the number could represent.
 A mapping of digit to letters (just like on the telephone buttons) is given below.
 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationsOfAPhoneNumber {
    String[]str={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits.length()==0||digits.contains("1"))return new ArrayList<>();
        List<String>res=new ArrayList<>();
        backtracing(res,new ArrayList<Character>(),digits,0);
        return res;
    }

    private void backtracing(List<String> res, ArrayList<Character> characterArrayList, String digits, int start) {
        if (start==digits.length()){
            StringBuilder stringBuilder=new StringBuilder();
            for (int i = 0; i < digits.length(); i++) {
                stringBuilder.append(characterArrayList.get(i));
            }
            res.add(stringBuilder.toString());}
        else for (int i = 0; i < str[Integer.parseInt(digits.charAt(start)+"")].length(); i++) {
            characterArrayList.add(str[Integer.parseInt(digits.charAt(start)+"")].charAt(i));
            backtracing(res,characterArrayList,digits,start+1);
            characterArrayList.remove(characterArrayList.size()-1);
        }
    }
    //LeetCode解法2 My java solution with FIFO queue
    public List<String> letterCombinations2(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }
    //LeetCode解法3
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations3(String digits) {
        List<String> ret = new LinkedList<String>();
        combination("", digits, 0, ret);
        return ret;
    }

    private void combination(String prefix, String digits, int offset, List<String> ret) {
        if (offset >= digits.length()) {
            ret.add(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, ret);
        }
    }
    public static void main(String[] args) {
        System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations2("213"));
    }
}
