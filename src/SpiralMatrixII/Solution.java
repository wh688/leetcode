package SpiralMatrixII;

public class Solution {
	public int[][] generateMatrix(int n) {
		int result[][] = new int[n][n];
		int layerTotal = n / 2;
		int num = 1;
		for (int layer = 0; layer < layerTotal; layer++) {
			for (int i = layer; i < n - 1 - layer; i++) {
				result[layer][i] = num;
				num++;
			}
			for (int i = layer; i < n - 1 - layer; i++) {
				result[i][n - 1 - layer] = num;
				num++;
			}
			for (int i = n - 1 - layer; i > layer; i--) {
				result[n - 1 - layer][i] = num;
				num++;
			}
			for (int i = n - 1 - layer; i > layer; i--) {
				result[i][layer] = num;
				num++;
			}
		}
		if (n % 2 == 1) {
			result[layerTotal][layerTotal] = num;
		}
		return result;
	}
}