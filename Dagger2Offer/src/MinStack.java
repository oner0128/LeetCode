import java.util.*;

/**
 * Created by rrr on 2017/5/4.
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class MinStack {
    Stack<Integer> stack = new Stack<>();
    List<Integer>list=new ArrayList<>();

    public void push(int node) {
        if (stack != null) {
            stack.push(node);
            list.add(node);
        }
    }

    public void pop() {
        if (!stack.empty())
        {stack.pop();
        list.remove(list.size()-1);}
    }

    public int top() {
        if (stack.empty())
            throw new EmptyStackException();
        else return stack.peek();
    }

    public int min() {
        if (stack.empty())
            throw new EmptyStackException();
        return Collections.min(list);
    }
}
