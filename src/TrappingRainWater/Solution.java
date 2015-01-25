package TrappingRainWater;

public class Solution {
    public int trap(int[] A) {
	if (A == null || A.length == 0) {
	    return 0;
	}
	int result = 0;
	int[] containers = new int[A.length];
	int max = 0;
	for (int i = 0; i < A.length; i++) {
	    containers[i] = max;
	    max = Math.max(max, A[i]);
	}
	max = 0;
	for (int i = A.length - 1; i >= 0; i--) {
	    containers[i] = Math.min(max, containers[i]);
	    max = Math.max(max, A[i]);
	    result += containers[i] - A[i] > 0 ? containers[i] - A[i] : 0;
	}
	return result;
    }
}
