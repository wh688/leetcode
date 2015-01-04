package BinarySearchTreeIterator;

import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class BSTIterator {
	private TreeNode current;
	private Stack<TreeNode> ancestors;
    public BSTIterator(TreeNode root) {
        this.current = root;
        this.ancestors = new Stack<TreeNode>();
        while(current != null) {
        	ancestors.push(current);
        	current = current.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !ancestors.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode current = ancestors.pop();
        int result = current.val;
        if(current.right != null) {
        	current = current.right;
        	ancestors.push(current);
        	current = current.left;
        	while(current != null) {
        		ancestors.push(current);
        		current = current.left;
        	}
        }
        return result;
    }
}

