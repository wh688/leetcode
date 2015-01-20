package NextPermutation;

public class Solution {
	public void nextPermutation(int[] num) {
		if (num == null || num.length == 0) {
			return;
		}
		int i = num.length - 2;
		while (i >= 0 && num[i] >= num[i + 1]) {
			i--;
		}
		if (i >= 0) {
			int j = i + 1;
			while (j < num.length && num[j] > num[i]) {
				j++;
			}
			j--;
			swap(num, i, j);
		}
		reverse(num, i + 1, num.length - 1);
	}

	public void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	public void reverse(int[] num, int start, int end) {
		for (int i = start, j = end; i < j; i++, j--) {
			swap(num, i, j);
		}
	}
}
