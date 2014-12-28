package SumRoottoLeafNumbers;

import java.util.LinkedList;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
    public int sumNumbers(TreeNode root) {
        return help(root, 0);
    }
    public int help(TreeNode root, int sum) {
    	if(root == null) {
    		return 0;
    	}
    	if(root.left == null && root.right == null) {
    		return sum * 10 + root.val;
    	}
    	return help(root.left, sum * 10 + root.val) + help (root.right, sum * 10 + root.val);
    }
}