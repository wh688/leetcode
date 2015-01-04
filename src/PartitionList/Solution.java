package PartitionList;
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}
public class Solution {
    public ListNode partition(ListNode head, int x) {
    	if(head == null) {
    		return null;
    	}
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode walker = helper;
        ListNode runner = helper;
        while(runner.next != null) {
        	if(runner.next.val < x) {
        		if(walker != runner) {
        			ListNode next = runner.next.next;
        			runner.next.next = walker.next;
        			walker.next = runner.next;
        			runner.next = next;
        		} else {
        			runner = runner.next;
        		}
        		walker = walker.next;
        	} else {
        		runner = runner.next;
        	}
        }
        return helper.next;
    }
}
