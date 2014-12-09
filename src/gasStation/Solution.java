package gasStation;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0 || cost.length != gas.length) {
        	return -1;
        }
        int total = 0;
        int sum = 0;
        int ptr = -1;
        for (int i = 0; i < gas.length; i++) {
        	int diff = gas[i] - cost[i];
        	total += diff;
        	sum += diff;
        	if (sum < 0) {
        		sum = 0;
        		ptr = i;
        	}
        }
        return total >= 0 ? ptr + 1 : -1;
    }
}
