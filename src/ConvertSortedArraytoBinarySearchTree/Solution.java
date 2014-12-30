package ConvertSortedArraytoBinarySearchTree;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        if(num == null) {
        	return null;
        }
        return sortedArrayToBSTHelper(num, 0, num.length - 1);
    }
    public TreeNode sortedArrayToBSTHelper(int[] num, int start, int end) {
    	if(start > end) {
    		return null;
    	}
    	TreeNode root = new TreeNode(num[(start + end) / 2]);
    	root.left = sortedArrayToBSTHelper(num, start, (start + end) / 2 - 1);
    	root.right = sortedArrayToBSTHelper(num, (start + end) / 2 + 1, end);
    	return root;
    }
}