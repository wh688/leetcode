package MaximalRectangle;

import java.util.*;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
	    return 0;
	}
	int m = matrix.length;
	int n = matrix[0].length;
	int max = 0;
	int[] height = new int[n];
	for (int i = 0; i < m; i++) {
	    for (int j = 0; j < n; j++) {
		if (matrix[i][j] == '0') {
		    height[j] = 0;
		} else {
		    height[j] += 1;
		}		
	    }
	    max = Math.max(max, largestRectangleArea(height));
	}
	return max;
    }
    public int largestRectangleArea(int[] height) {
	Stack<Integer> stack = new Stack<Integer>();
	int i = 0;
	int maxArea = 0;
	int[] h = new int[height.length + 1];
	h = Arrays.copyOf(height, height.length + 1);
	while (i < h.length) {
	    if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
		stack.push(i++);
	    } else {
		int t = stack.pop();
		maxArea = Math.max(maxArea, h[t]
			* (stack.isEmpty() ? i : i - stack.peek() - 1));
	    }
	}
	return maxArea;
    }
}
