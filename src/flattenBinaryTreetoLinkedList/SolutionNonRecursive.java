package flattenBinaryTreetoLinkedList;

import java.util.Stack;

/*
 * Given a binary tree, flatten it to a linked list in-place.
 */

public class SolutionNonRecursive {
	public void flatten(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode> ();
		TreeNode p = root;
		while (p != null || !stack.empty()) {
			if (p.right != null) {
				stack.push(p.right);
			}
			if (p.left != null) {
				p.right = p.left;
				p.left = null;				
			} else if (! stack.empty()) {
				TreeNode temp = stack.pop();
				p.right = temp;
			}
			p = p.right;
		}
	}
}
