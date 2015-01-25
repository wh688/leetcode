package validParentheses;

import java.util.Stack;

/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 */

public class Solution {
    public boolean isValid(String s) {
	if (s.length() <= 1) {
	    return false;
	}
	Stack<Character> stack = new Stack<Character>();
	for (int i = 0; i < s.length(); i++) {
	    char p = s.charAt(i);
	    if (p == '(' || p == '[' || p == '{') {
		stack.push(p);
	    } else {
		if (stack.size() == 0) {
		    return false;
		}
		char top = stack.pop();
		if ((top == '(' && p == ')') || (top == '[' && p == ']')
			|| (top == '{' && p == '}')) {
		    continue;
		} else {
		    return false;
		}
	    }
	}
	return stack.size() == 0;
    }
}
