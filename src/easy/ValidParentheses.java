package easy;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by rrr on 2017/4/16.
 * 20. Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
    //两点法失败
    // Input:
    /*"()[]{}"
    Output:
            false
    Expected:
            true*/
    public static boolean isValid(String s) {
        if (s.length() == 0) return true;
        char[] chars = s.toCharArray();
        String character = "(){}[]";
        int head = 0, rear = s.length() - 1;
        while (head <= rear) {
            if (character.indexOf(chars[head]) % 2 == 1) return false;
            else if (character.indexOf(chars[head++]) + 1 != character.indexOf(chars[rear--])) return false;
        }
        return true;
    }
    //10ms
    public static boolean isValid2(String s) {
        int len = s.length();
        if ((len & 1) == 1) return false;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        String character = "(){}[]";
        for (char c : chars) {
            int index=character.indexOf(c);
            if (index % 2 == 1&&!stack.isEmpty()) {if (character.indexOf(stack.pop())!=index-1)return false;}
            else  stack.push(c);
        }
        return stack.size()==0?true:false;
    }
    //LeetCode解法 15ms
    public boolean isValid3(String s) {
        if ((s.length() & 1) == 1) return false;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
    //11ms
    public static boolean isValid4(String s) {
        if ((s.length() & 1) == 1) return false;
        Stack<Integer> stack = new Stack<>();
        String character = "(){}[]";
        for (char c : s.toCharArray()) {
            int index=character.indexOf(c);
            if (index % 2 == 1) {
                if (stack.isEmpty()||stack.pop()!=index-1)return false;}
            else  stack.push(index);
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(isValid2(""));
        System.out.println(isValid2("{[]["));
        System.out.println(isValid2("]{[]}")); System.out.println(isValid2("()[]{}"));
        System.out.println("cvvc".substring(0, 3));
    }
}
