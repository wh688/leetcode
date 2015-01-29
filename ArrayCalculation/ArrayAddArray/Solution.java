package ArrayAddArray;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
	int data1[] = new int[] { 9, 9, 9, 9 };
	int data2[] = new int[] { 9, 9, 9 };
	System.out.println(Arrays.toString(arrayAddArray(data1, data2)));
    }

    public static int[] arrayAddArray(int[] num1, int[] num2) {
	int len = Math.max(num1.length, num2.length);
	int[] longNum = num1.length > num2.length ? num1 : num2;
	int[] shortNum = num1.length > num2.length ? num2 : num1;
	int[] result = new int[len + 1];
	int carry = 0;
	int index = len;
	int i, j;
	for (i = longNum.length - 1, j = shortNum.length - 1; i >= 0 && j >= 0; i--, j--) {
	    int temp = longNum[i] + shortNum[j] + carry;
	    result[index] = temp % 10;
	    carry = temp / 10;
	    index--;
	}
	if (i > 0) {
	    for (int k = i; k >= 0; k--) {
		int temp = longNum[i] + carry;
		result[k] = temp % 10;
		carry = temp / 10;
	    }
	}
	if (carry > 0) {
	    result[0] = carry;
	    return result;
	} else {
	    result = Arrays.copyOfRange(result, 1, result.length);
	}
	return result;
    }
}
