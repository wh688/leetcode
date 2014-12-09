package pathSumII;

/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
*/

import java.util.ArrayList;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        pathHelper(paths, path, root, sum);
        return paths;
    }
	public void pathHelper(ArrayList<ArrayList<Integer>> paths,  
			ArrayList<Integer> path, TreeNode root, int sum) {
		if (root == null) {
			return;
		}
		sum = sum - root.val;
		if (root.left == null && root.right == null && sum == 0) {
			path.add(root.val);
			paths.add(new ArrayList<Integer> (path));
			path.remove(path.size() - 1);
			return;
		}
		path.add(root.val);
		pathHelper(paths, path, root.left, sum);
		pathHelper(paths, path, root.right, sum);
		path.remove(path.size() - 1);
	}
}
