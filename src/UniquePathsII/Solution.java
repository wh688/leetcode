package UniquePathsII;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	int result = 0;
	if (obstacleGrid == null || obstacleGrid.length == 0
		|| obstacleGrid[0].length == 0) {
	    return result;
	}
	int sum[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
	for (int i = 0; i < obstacleGrid.length; i++) {
	    for (int j = 0; j < obstacleGrid[0].length; j++) {
		sum[i][j] = 0;
	    }
	}
	for (int i = 0; i < obstacleGrid.length; i++) {
	    if (obstacleGrid[i][0] == 0) {
		sum[i][0] = 1;
	    } else {
		break;
	    }
	}
	for (int i = 0; i < obstacleGrid[0].length; i++) {
	    if (obstacleGrid[0][i] == 0) {
		sum[0][i] = 1;
	    } else {
		break;
	    }
	}
	for (int i = 1; i < obstacleGrid.length; i++) {
	    for (int j = 1; j < obstacleGrid[0].length; j++) {
		if (obstacleGrid[i][j] != 1) {
		    sum[i][j] = sum[i - 1][j] + sum[i][j - 1];
		} else {
		    sum[i][j] = 0;
		}
	    }
	}
	result = sum[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
	return result;
    }
}
