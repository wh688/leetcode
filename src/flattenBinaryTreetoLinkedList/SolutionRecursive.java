package flattenBinaryTreetoLinkedList;

/*
 * Given a binary tree, flatten it to a linked list in-place.
 */

public class SolutionRecursive {
	TreeNode lastVisited;
	public void flatten(TreeNode root) {
        if(root == null) {
        	return;
        }
        TreeNode realright = root.right;
        if (lastVisited != null) {
        	lastVisited.left = null;
        	lastVisited.right = root;
        }
        lastVisited = root;
        flatten(root.left);
        flatten(realright);
    }
}
