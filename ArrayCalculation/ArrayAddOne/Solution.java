package ArrayAddOne;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
	int data[] = new int[] { 9, 9, 9, 9 };
	System.out.println(Arrays.toString(arrayAddOne(data)));
    }

    public static int[] arrayAddOne(int[] num) {
	int[] result = new int[num.length + 1];
	int carry = 1;
	for (int i = num.length - 1; i >= 0; i--) {
	    int temp = num[i] + carry;
	    result[i + 1] = temp % 10;
	    carry = temp / 10;
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
