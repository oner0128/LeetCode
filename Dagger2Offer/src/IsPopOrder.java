import java.util.Stack;

/**
 * Created by rrr on 2017/5/4.
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class IsPopOrder {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length==0)return true;
        Stack<Integer>stack=new Stack<>();
        stack.push(pushA[0]);
        int pushIndex=1;int popIndex=0;
        while (pushIndex<pushA.length||popIndex<popA.length){
            if (popA[popIndex]==stack.peek()){stack.pop();popIndex++;}
            else if (popA[popIndex]!=stack.peek()&&pushIndex==pushA.length)return false;
            else stack.push(pushA[pushIndex++]);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(IsPopOrder(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1}));
        System.out.println(IsPopOrder(new int[]{1,2,3,4,5},new int[]{4,3,5,1,2}));
    }
}
