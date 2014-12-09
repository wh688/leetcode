package minimumDepthOfBinaryTree;

/*
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
*/

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public int minDepth(TreeNode root) {
        if(root == null) {
        	return 0;
        }
        return getMinDepth(root);        
    }
	public int getMinDepth (TreeNode root) {
		if(root == null) {
        	return Integer.MAX_VALUE;
        }
        if(root.left == null && root.right == null) {
        	return 1;
        }
        return Math.min(getMinDepth(root.left), getMinDepth(root.right)) + 1;
	}
}
