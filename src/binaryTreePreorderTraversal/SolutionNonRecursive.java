package binaryTreePreorderTraversal;

import java.util.*;

public class SolutionNonRecursive {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
        	return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode> ();
        stack.push(root);
        while (!stack.isEmpty()) {
        	TreeNode head = stack.peek();
        	result.add(head.val);
        	if(head.right != null) {
        		stack.push(head.right);
        	}
        	if(head.left != null) {
        		stack.push(head.left);
        	}
        }
        return result;
    }
}
