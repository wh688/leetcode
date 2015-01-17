package UniquePaths;

public class Solution {
	public int uniquePaths(int m, int n) {
		double denom = 1;
		double dom = 1;
		int big = Math.max(m, n) - 1;
		int small = Math.min(m, n) - 1;
		for (int i = 1; i <= small; i++) {
			denom *= i;
			dom *= (big + small + 1 - i);
		}
		return (int) (dom / denom);
	}
}
