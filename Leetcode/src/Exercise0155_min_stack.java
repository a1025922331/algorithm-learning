import java.util.Deque;
import java.util.LinkedList;

public class Exercise0155_min_stack {
    Deque stack;
    Deque minStack;

    /**
     * initialize your data structure here.
     */
    public Exercise0155_min_stack() {
        stack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        Integer min = (Integer) minStack.peek();
        minStack.push(min > x ? x : min);
        stack.push(x);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return (int) stack.peek();
    }

    public int getMin() {
        return (int) minStack.peek();
    }
}