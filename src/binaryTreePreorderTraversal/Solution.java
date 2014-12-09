package binaryTreePreorderTraversal;

import java.util.ArrayList;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public void helper (TreeNode root, ArrayList<Integer> result) {
		if (root == null) {
			return;
		}
		result.add(root.val);
		helper(root.left, result);
		helper(root.right, result);
	}
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
        	return result;
        }
        helper(root, result);
        return result;
    }
}
