package GenerateParentheses;

import java.util.ArrayList;

public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
    	ArrayList<String> result = new ArrayList<String>();
    	if(n <= 0) {
    		return result;
    	}
    	DFS(result, "", n, n);
    	return result;
    }
    public void DFS(ArrayList<String> result, String solution, int left, int right) {
    	if(left > right || left < 0 || right < 0) {
    		return;
    	}
    	if(left == 0 && right == 0) {
    		result.add(solution);
    		return;
    	}
    	if(left > 0) {
    		DFS(result, solution + '(', left - 1, right);
    	}
    	if(right > 0) {
    		DFS(result, solution + ')', left, right - 1);
    	}
    }
}
