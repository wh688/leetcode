package pathSum;

import java.util.LinkedList;

public class Solution_NonRecursive {
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) return false;
        LinkedList<TreeNode> node = new LinkedList<TreeNode> ();
        LinkedList<Integer> value = new LinkedList<Integer> ();
        node.offer(root);
        value.offer(root.val);
        while(!node.isEmpty()) {
        	TreeNode curr = node.poll();
        	int sumValue = value.poll();
        	if (curr.left == null && curr.right == null && sumValue == sum) {
        		return true;
        	}
        	if (curr.left != null) {
        		node.add(curr.left);
        		value.add(sumValue + curr.left.val);
        	}
        	if (curr.right != null) {
        		node.add(curr.right);
        		value.add(sumValue + curr.right.val);
        	}
        }
        return false;
    }
}
