package DivideTwoIntegers;

public class Solution {
	public static void main(String args[]) {
		System.out.println(divide(-2147483648, -1));
	}
    public static int divide(int dividend, int divisor) {
        boolean isNeg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        long ans = 0;
        while(a >= b) {
        	int shift = 0;
        	while((b << shift) <= a) {
        		shift++;
        	}
        	ans += (long)1 << (shift - 1);   
        	a = a - (b << (shift - 1));
        }
        if (!isNeg) {
            return (int)Math.min(ans, Integer.MAX_VALUE);
        } else {
            return (int)-ans;
        }
    }
}