package SearchForARange;

public class Solution {
	public int[] searchRange(int[] A, int target) {
		int l, r, mid;
		int[] bound = new int[2];
		l = 0;
		r = A.length - 1;
		while (l + 1 < r) {
			mid = l + (r - l) / 2;
			if (A[mid] == target) {
				r = mid;
			} else if (A[mid] < target) {
				l = mid;
			} else {
				r = mid;
			}
		}
		if (A[l] == target) {
			bound[0] = l;
		} else if (A[r] == target) {
			bound[0] = r;
		} else {
			bound[0] = bound[1] = -1;
			return bound;
		}
		l = 0;
		r = A.length - 1;
		while (l + 1 < r) {
			mid = l + (r - l) / 2;
			if (A[mid] == target) {
				l = mid;
			} else if (A[mid] < target) {
				l = mid;
			} else {
				r = mid;
			}
		}
		if (A[r] == target) {
			bound[1] = r;
		} else if (A[l] == target) {
			bound[1] = l;
		} else {
			bound[0] = bound[1] = -1;
			return bound;
		}
		return bound;
	}
}
