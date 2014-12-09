package searchInRotatedSortedArrayII;

public class Solution {
	public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) {
        	return false;
        }
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
        	int mid = (low + high) / 2;
        	if (target < A[mid]) {
        		if (A[mid] < A[high]) {
        			high = mid - 1;
        		} else if (A[mid] == A[high]) {
        			high--;
        		} else {
        			if (target < A[low]) {
        				low = mid + 1;
        			} else {
        				high = mid - 1;
        			}
        		}
        	} else if (target > A[mid]) {
        		if (A[low] < A[mid]) {
        			low = mid + 1;
        		} else if (A[mid] == A[low]) {
        			low++;
        		} else {
        			if (target > A[high]) {
        				high = mid - 1;
        			} else {
        				low = mid + 1;
        			}
        		}
        	} else {
        		return true;
        	}
        }
        return false;
    }
}
