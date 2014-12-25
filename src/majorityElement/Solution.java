package majorityElement;

public class Solution {
	public int majorityElement(int[] num) {
		int majority = num[0];
		int count = 0;
	  	for(int i = 0; i < num.length; i++) {
	  		if(count == 0) {
	  			majority = num[i];
	  			count = 1;
	  		} else if(num[i] == majority) {
	  			count ++;
	  		} else {
	  			count --;
	  		}
	  	}
	  	return majority;
	}
}