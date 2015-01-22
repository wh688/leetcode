package NQueens;

import java.util.*;

public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
	ArrayList<String[]> result = new ArrayList<String[]>();
	helper(n, 0, new int[n], result);
	return result;
    }

    private void helper(int n, int row, int[] colForRow,
	    ArrayList<String[]> result) {
	if (row == n) {
	    String[] item = new String[n];
	    for (int i = 0; i < n; i++) {
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < n; j++) {
		    if (colForRow[i] == j) {
			sb.append('Q');
		    } else {
			sb.append('.');
		    }
		}
		item[i] = sb.toString();
	    }
	    result.add(item);
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
