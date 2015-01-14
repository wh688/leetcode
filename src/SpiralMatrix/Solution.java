package SpiralMatrix;

import java.util.ArrayList;

public class Solution {
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer> ();
		if(matrix == null || matrix.length == 0|| matrix[0].length ==0 ) {
			return result;
		} 
		int min = Math.min(matrix.length, matrix[0].length);
		int layerTotal = min / 2;
		for (int layer = 0; layer < layerTotal; layer ++) {
			for (int i = layer; i < matrix[0].length - 1 - layer; i++) {
				result.add(matrix[layer][i]);
			}
			for (int i = layer; i < matrix.length - 1 - layer; i++) {
				result.add(matrix[i][matrix[0].length - 1 - layer]);
			}
			for (int i = matrix[0].length - 1 - layer; i > layer; i--) {
				result.add(matrix[matrix.length - 1 - layer][i]);
			}
			for (int i = matrix.length - 1 - layer; i > layer; i--) {
				result.add(matrix[i][layer]);
			}
		}
		if (min % 2 == 1) {
			if(min == matrix.length) {
				for (int i = layerTotal; i < matrix[0].length - layerTotal; i++) {
					result.add(matrix[layerTotal][i]);
				}
			} else {
				for (int i = layerTotal; i < matrix.length - layerTotal; i++) {
					result.add(matrix[i][layerTotal]);
				}				
			}
		}
		return result;
	}
}
