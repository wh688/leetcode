package binaryTreeInorderTraversal;

import java.util.*;

public class SolutionNonRecursive {
	public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> lst = new ArrayList<Integer>();
        if(root == null) {
            return lst;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while(!stack.empty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode t = stack.pop();
                lst.add(t.val);
                p = t.right;
            }
        }
        return lst;
    }
}
