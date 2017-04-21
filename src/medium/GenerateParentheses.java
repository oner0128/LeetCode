package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by rrr on 2017/4/20.
 * 22. Generate Parentheses Add to List
 * Total Accepted: 138205
 * Total Submissions: 319329
 * Difficulty: Medium
 * Contributor: LeetCode
 * Given n pairs of parentheses,
 * write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class GenerateParentheses {
    String[] str = {"(", ")"};
    //75ms
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate("", res, n, 0);
        return res;
    }

    private void generate(String s, List<String> res, int n, int start) {
        if (start == n * 2 ) {if (isValid(s)) res.add(s);}
        else for (int i = 0; i < 2; i++) {
                String ss = s + str[i];
                generate(ss, res, n, start + 1);
                ss = ss.substring(0, ss.length() - 1);
            }
    }

    public boolean isValid(String s) {
        int len = s.length();
        if ((len & 1) == 1) return false;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        String character = "(){}[]";
        for (char c : chars) {
            int index = character.indexOf(c);
            if (index % 2 == 1 && !stack.isEmpty()) {
                if (character.indexOf(stack.pop()) != index - 1) return false;
            } else stack.push(c);
        }
        return stack.size() == 0 ? true : false;
    }
    //LeetCode解法
    public List<String> generateParenthesis2(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis2(3));
    }
}
