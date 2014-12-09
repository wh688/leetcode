package combinations;
import java.util.*;
/*
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 */

public class Solution {
	
	public static void main(String[] args) {
		System.out.println(combine(4, 2));
	}
	
	public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
		ArrayList<Integer> solution = new ArrayList<Integer> ();
		help (n, k, 1, result, solution);
		return result;
    }
	public static void help (int n, int k, int start, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> solution) {
		if(solution.size() == k) {
			result.add(new ArrayList(solution));
			return;
		}
		for (int i = start; i <= n; i++) {
			solution.add(i);
			help(n, k, i + 1, result, solution);
			solution.remove(solution.size() - 1);
		}
	}
}
