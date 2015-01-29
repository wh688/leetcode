package ArrayMultipleArray;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
	int data1[] = new int[] { 9, 9, 9, 9 };
	int data2[] = new int[] { 9, 9 };
	System.out.println(Arrays.toString(arrayMultiArray(data1, data2)));
    }

    public static int[] arrayMultiArray(int[] num1, int[] num2) {
	int[] longNum = num1.length > num2.length ? num1 : num2;
	int[] shortNum = num1.length > num2.length ? num2 : num1;
	int longLen = longNum.length;
	int shortLen = shortNum.length;
	int[] result = new int[longLen + shortLen];
	for (int i = longLen - 1; i >= 0; i--) {
	    for (int j = shortLen - 1; j >= 0; j--) {
		result[i + j + 1] += longNum[i] * shortNum[j];
	    }
	}
	int carry = 0;
	for (int i = longLen + shortLen - 1; i>=0; i--) {
	    int digit = result[i] % 10;
	    carry = result[i] / 10;
	    result[i] = digit;
	    if (i > 0) {
		result[i-1] += carry;
	    }
	}
	while (result.length > 0 && result[0] ==0) {
	    result = Arrays.copyOfRange(result, 1, result.length);
	}
	if (result.length == 0) {
	    return new int[] {0};
	}
	return result;
    }
}
