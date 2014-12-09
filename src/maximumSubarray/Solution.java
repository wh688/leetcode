package maximumSubarray;

/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
*/

public class Solution {
	public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) {
        	return 0;
        }
        int[] sum = new int[A.length];
        sum[0] = A[0];
        int max = sum[0];
        for (int i = 1; i < A.length; i++) {
        	sum[i] = Math.max(sum[i-1] + A[i], A[i]);
        	max = Math.max(max, sum[i]);
        }
        return max;
    }
}
