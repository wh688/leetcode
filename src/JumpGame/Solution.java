package JumpGame;

public class Solution {
	public boolean canJump(int[] A) {
		boolean result = false;
		if (A == null || A.length == 0) {
			return result;
		}
		int reach = 0;
		for (int i = 0; i < A.length && i <= reach; i++) {
			reach = Math.max(reach, A[i] + i);
		}
		if (reach >= A.length - 1) {
			result = true;
		}
		return result;
	}
}
