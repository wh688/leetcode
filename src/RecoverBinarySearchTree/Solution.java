package RecoverBinarySearchTree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
	val = x;
    }
}

public class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode last;

    public void recoverTree(TreeNode root) {
	first = null;
	second = null;
	last = null;
	traverse(root);
	if (first != null && second != null) {
	    int temp = first.val;
	    first.val = second.val;
	    second.val = temp;
	}
    }

    public void traverse(TreeNode root) {
	if (root == null) {
	    return;
	}
	traverse(root.left);
	if (last == null) {
	    last = root;
	} else {
	    if (last.val > root.val) {
		if (first == null) {
		    first = last;
		}
		second = root;
	    }
	    last = root;
	}
	traverse(root.right);
    }
}
