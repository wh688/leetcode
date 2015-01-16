package ContainerWithMostWater;

public class Solution {
	public int maxArea(int[] height) {
		int maxArea = 0;
		if (height == null || height.length == 0) {
			return maxArea;
		}
		int l = 0;
		int r = height.length - 1;
		while (l < r) {
			maxArea = Math.max(maxArea, (r - l) * Math.min(height[l], height[r]));
			if (height[l] < height[r]) {
				l++;
			} else {
				r--;
			}
		}
		return maxArea;
	}
}
