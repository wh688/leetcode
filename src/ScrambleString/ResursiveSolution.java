package ScrambleString;

import java.util.*;

public class ResursiveSolution {
    public boolean isScramble(String s1, String s2) {
	if (s1.length() != s2.length()) {
	    return false;
	}
	if (s1.length() == 0 || s1.equals(s2)) {
	    return true;
	}
	if (!strSort(s1).equals(strSort(s2))) {
	    return false;
	}
	for (int i = 1; i < s1.length(); i++) {
	    String s11 = s1.substring(0, i);
	    String s12 = s1.substring(i);
	    String s21 = s2.substring(0, i);
	    String s22 = s2.substring(i);
	    String s23 = s2.substring(0, s2.length() - i);
	    String s24 = s2.substring(s2.length() - i);
	    if ((isScramble(s11, s21) && isScramble(s12, s22))
		    || (isScramble(s11, s24) && isScramble(s12, s23))) {
		return true;
	    }
	}
	return false;
    }

    private String strSort(String s) {
	char[] ch = s.toCharArray();
	Arrays.sort(ch);
	return new String(ch);
    }
}
