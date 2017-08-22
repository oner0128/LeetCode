package hard;

import java.util.Stack;

/**
 * Created by rrr on 2017/8/22.
 * 32. Longest Valid Parentheses
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * <p>
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class LongestValidParentheses {
    //brute force (time limit) O(n^3)  space O(n)
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j += 2) {
                if (isValid(s.substring(i, j)))
                    max = Math.max(max, j - i);
            }
        }
        return max;
    }

    public static boolean isValid(String s) {
        int len = s.length();
        if ((len & 1) == 1) return false;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        String character = "()";
        for (char c : chars) {
            int index = character.indexOf(c);
            if (index % 2 == 1 && !stack.isEmpty()) {
                if (character.indexOf(stack.pop()) != index - 1) return false;
            } else stack.push(c);
        }
        return stack.size() == 0;
    }

    //dp   O(n)  space O(n)
    public int longestValidParentheses2(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(')
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                else if (i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(')
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    //stack   O(n)  space O(n)
    public int longestValidParentheses3(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                stack.pop();
                if (!stack.isEmpty()) max = Math.max(max, i - stack.peek());
                else stack.push(i);
            } else stack.push(i);
        }
        return max;
    }

    //two traversal    left and right O(n)  space O(n)
    public int longestValidParentheses4(String s) {
        if (s == null || s.length() == 0) return 0;
        int max = 0;
        int leftCount = 0, rightCount = 0;
        //left traversal
        for (int i = 0; i < s.length(); i++) {
            leftCount = s.charAt(i) == '(' ? leftCount + 1 : leftCount;
            rightCount = s.charAt(i) == ')' ? rightCount + 1 : rightCount;
            if (leftCount == rightCount) max = Math.max(max, leftCount + rightCount);
            if (rightCount > leftCount) {
                leftCount = 0;
                rightCount = 0;
            }
        }
        leftCount = 0;
        rightCount = 0;
        //right traversal
        for (int i = s.length() - 1; i >= 0; i--) {
            leftCount = s.charAt(i) == '(' ? leftCount + 1 : leftCount;
            rightCount = s.charAt(i) == ')' ? rightCount + 1 : rightCount;
            if (leftCount == rightCount) max = Math.max(max, leftCount + rightCount);
            if (leftCount > rightCount) {
                leftCount = 0;
                rightCount = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        new LongestValidParentheses().longestValidParentheses("()(()");
    }
}
