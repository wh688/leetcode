package binaryTreeMaximumPathSum;

/*
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public int maxPathSum(TreeNode root) {
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        help (root, max);
        return max[0];
    }
	public int help (TreeNode root, int[] max) {
		if(root == null) {
			return 0;
		}
		int left = help(root.left, max);
		int right = help(root.right, max);
		int ans = Math.max(root.val, Math.max(left + root.val, right + root.val));
		max[0] = Math.max(max[0], Math.max(ans, root.val + left + right));
		return ans;
	}
}
