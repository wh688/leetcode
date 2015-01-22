package NQueensII;

import java.util.*;

public class Solution {
    public int totalNQueens(int n) {
	int[] result = new int[1];
	helper(n, 0, new int[n], result);
	return result[0];
    }

    private void helper(int n, int row, int[] colForRow, int[]result) {
	if (row == n) {
	    result[0]++;
	    return;
	}
	for (int i = 0; i < n; i++) {
	    colForRow[row] = i;
	    if (isValid(row, colForRow)) {
		helper(n, row + 1, colForRow, result);
	    }
	}
    }

    private boolean isValid(int row, int[] colForRow) {
	for (int i = 0; i < row; i++) {
	    if (colForRow[row] == colForRow[i]
		    || Math.abs(colForRow[row] - colForRow[i]) == row - i) {
		return false;
	    }
	}
	return true;
    }
}
