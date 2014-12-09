package binaryTreeZigzagLevelOrderTraversal;

/*
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList result = new ArrayList();
        int ind = 1;
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
        	if (ind == 1) {
        		ind = ind * (-1);
        	} else {
        		Collections.reverse(level);
        		ind = ind * (-1);
        	}
        	result.add(level);
        }
        return result;
    }
}
