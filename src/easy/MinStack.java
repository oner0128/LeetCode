package easy;
/*
* 155. Min Stack
*
* Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
* */

public class MinStack {
    /**
     * initialize your data structure here.
     */
    int[] carry;
    int total, cur;

    public MinStack() {
        total = 16;
        cur = 0;
        carry = new int[total];
    }

    public void push(int x) {
        if (cur >= total) {
            total *= 2;
            int[] tmp = new int[total];
            for (int i = 0; i < carry.length; i++) {
                tmp[i] = carry[i];
            }
            carry = tmp;
        }
        carry[cur++] = x;
    }

    public void pop() {
        cur--;
        if (cur <= total/2) {
            total /= 2;
            int[] tmp = new int[total];
            for (int i = 0; i < cur; i++) {
                tmp[i] = carry[i];
            }
            carry = tmp;
        }

    }

    public int top() {
        return carry[cur-1];
    }

    public int getMin() {
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < cur; i++) {
            if (carry[i]<min)min=carry[i];
        }
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack=new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
