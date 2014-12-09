package plusOne;

/*
Given a non-negative number represented as an array of digits, plus one to the number.
The digits are stored such that the most significant digit is at the head of the list.
*/

public class Solution {
	public int[] plusOne(int[] digits) {
		int[] resultBase = new int[1];
		resultBase[0] = 1;
        if (digits == null || digits.length == 0) {
        	return resultBase;
        }
        int carry = 1;
        int[] result = new int[digits.length + 1];
        for (int i = digits.length - 1; i >= 0; i--) {
        	int temp = digits[i] + carry;
        	result[i + 1] = (digits[i] + carry) % 10;
        	if(temp <= 9)
        		carry = 0;
        	else
        		carry = 1;
        }	
        if (carry != 0) {
        	result[0] = 1;
        	return result;
        } else {
        	int[] trueResult = new int[digits.length];
        	for (int i = 0; i < digits.length; i++) {
        		trueResult[i] = result[i + 1];
        	}
        	return trueResult;
        }
    }
}
