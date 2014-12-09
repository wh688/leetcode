package combinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        List<Integer> solution = new ArrayList<Integer> ();
        if (candidates.length == 0 || candidates == null) {
        	return result;
        }
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        help (candidates, target, 0, result, solution, used);
        return result;
    }
	public void help (int[] candidates, int target, int start, 
			List<List<Integer>> result, List<Integer> solution, boolean[] used) {
		if (target < 0) {
			return;
		} 
		if (target == 0) {
			result.add(new ArrayList<Integer> (solution));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			if (!used[i]) {
				if ((i > 0 && candidates[i] == candidates[i - 1]) && used[i - 1] == false) {
					continue;
				}
				solution.add(candidates[i]);
				used[i] = true;
				int newTarget = target - candidates[i];
				help (candidates, newTarget, i, result, solution, used);
				used[i] = false;
				solution.remove(solution.size() - 1);
			}
		}
	}
}