package fractionToRecurringDecimal;

import java.util.HashMap;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0)
        	return "0";
        if(denominator == 0)
        	return "NaN";
        StringBuilder result = new StringBuilder();
        Long n = new Long(numerator);
        Long d = new Long(denominator);
        if(n * d < 0)
        	result.append("-");
        n = Math.abs(n);
        d = Math.abs(d);
        result.append(Long.toString(n / d));
        if(n % d == 0)
        	return result.toString();
        else
        	result.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        Long r = n % d;
        while(r > 0) {
        	if(map.containsKey(r)) {
                result.insert(map.get(r), "(");
                result.append(")");
                break;        		
        	}
            map.put(r, result.length());
            r *= 10;
            result.append(Long.toString(r / d));
            r %= d;
        }
        return result.toString();
    }
}
