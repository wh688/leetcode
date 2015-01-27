package binaryTreeInorderTraversal;

import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
	val = x;
    }
}

public class Solution {
    public void helper(TreeNode root, ArrayList<Integer> result) {
	if (root == null) {
	    return;
	}
	helper(root.left, result);
	result.add(root.val);
	helper(root.right, result);
    }

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
	ArrayList<Integer> result = new ArrayList<Integer>();
	if (root == null) {
	    return result;
	}
	helper(root, result);
	return result;
    }
}
