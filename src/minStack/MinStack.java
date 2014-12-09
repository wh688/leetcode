package minStack;
import java.util.Stack;

/*
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */

public class MinStack extends Stack<Integer> {
	
	public static void main (String[] args) {
		MinStack ms = new MinStack();
		ms.push(-3);
		return;
	}
	
	public MinStack () {
        minStack = new Stack<Integer>();    
    }
	
	private Stack<Integer> minStack;
	
    public void push(int x) {
        if (x <= getMin()) {
        	minStack.push(x);
        }
       	super.push(x);
    }

    public Integer pop() {
        int value = super.pop();
        if (value == getMin()) {
        	minStack.pop();
        }
        return value;
    }

    public int top() {
    	int value = super.peek();
    	return value;
    }

    public int getMin() {
    	if (minStack.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return minStack.peek();
        }
    }
}
