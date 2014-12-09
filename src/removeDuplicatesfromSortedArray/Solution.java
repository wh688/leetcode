package removeDuplicatesfromSortedArray;

/*
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 */

public class Solution {
	public int removeDuplicates(int[] A) {
        if (A.length == 0 || A == null) {
        	return 0;
        }
        int len = 0;
        for (int i = 0; i < A.length; i++) {
        	if (A[i] != A[len]) {
        		A[++len] = A[i];
        	}
        }
        return len + 1;
    }
}
