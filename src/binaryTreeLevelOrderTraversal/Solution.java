package binaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * BFS
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList result = new ArrayList();
        if (root == null) {
        	return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode> ();
        queue.offer(root);
        while (!queue.isEmpty()) {
        	ArrayList<Integer> level = new ArrayList<Integer> ();
        	int size = queue.size();
        	for (int i = 0; i < size; i++) {
        		TreeNode head = queue.poll();
        		level.add(head.val);
        		if (head.left != null) {
        			queue.offer(head.left);
        		}
        		if (head.right != null) {
        			queue.offer(head.right);
        		}
        	}
        	result.add(level);
        }
        return result;
    }
}
