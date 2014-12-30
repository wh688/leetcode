package ValidateBinarySearchTree;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE - 1L, Integer.MAX_VALUE + 1L);
    }
    public boolean isBST(TreeNode root, long low, long high) {
    	if(root == null) {
    		return true;
    	}
    	if(low < root.val && root.val < high) {
    		return isBST(root.left, low, root.val) && isBST(root.right, root.val, high);
    	} else {
    		return false;
    	}
    }
}
