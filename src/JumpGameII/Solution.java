package JumpGameII;

public class Solution {
	public int jump(int[] A) {
		int steps = 0;
		if (A == null || A.length == 0) {
			return steps;
		}
		int lastPos = 0;
		int reach = 0;
		for (int i = 0; i <= reach && i < A.length; i++) {
			if (i > lastPos) {
				steps++;
				lastPos = reach;
			}
			reach = Math.max(reach, A[i] + i);
		}
		if (reach < A.length - 1) {
			return 0;
		}
		return steps;
	}
}
