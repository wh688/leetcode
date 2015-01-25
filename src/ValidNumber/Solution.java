package ValidNumber;

public class Solution {
    public boolean isNumber(String s) {
	if (s == null || s.length() == 0) {
	    return false;
	}
	s = s.trim();
	if (s == null || s.length() == 0) {
	    return false;
	}
	int i = 0;
	int e = s.length() - 1;
	if (s.charAt(0) == '+' || s.charAt(0) == '-') {
	    i++;
	}
	boolean isNum = false;
	boolean hasDot = false;
	boolean hasExp = false;
	while (i <= e) {
	    char c = s.charAt(i);
	    if (Character.isDigit(c)) {
		isNum = true;
	    } else if (c == '.') {
		if (hasDot || hasExp) {
		    return false;
		}
		hasDot = true;
	    } else if (c == 'e') {
		if (hasExp || isNum == false) {
		    return false;
		}
		hasExp = true;
		isNum = false;
	    } else if (c == '+' || c == '-') {
		if (s.charAt(i - 1) != 'e') {
		    return false;
		}
	    } else {
		return false;
	    }
	    i++;
	}
	return isNum;
    }
}
