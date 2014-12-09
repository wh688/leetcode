package combinationSum;

import java.util.*;

/*
 * Given a set of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 */

public class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        List<Integer> solution = new ArrayList<Integer> ();
        if (candidates.length == 0 || candidates == null) {
        	return result;
        }
        Arrays.sort(candidates);
        help (candidates, target, 0, result, solution);
        return result;
    }
	public void help (int[] candidates, int target, int start, List<List<Integer>> result, List<Integer> solution) {
		if (target < 0) {
			return;
		} 
		if (target == 0) {
			result.add(new ArrayList<Integer> (solution));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			if ((i > 0 && candidates[i] == candidates[i - 1])) {
				continue;
			}
			solution.add(candidates[i]);
			int newTarget = target - candidates[i];
			help (candidates, newTarget, i, result, solution);
			solution.remove(solution.size() - 1);
		}
	}
}
