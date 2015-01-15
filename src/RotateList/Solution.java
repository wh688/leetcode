package RotateList;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	public ListNode rotateRight(ListNode head, int n) {
		ListNode runner = head;
		ListNode walker = head;
		if (head == null) {
			return null;
		}
		int idx = 0;
		while (runner != null && idx < n) {
			runner = runner.next;
			idx++;
		}
		if (runner == null) {
			n %= idx;
			runner = head;
			idx = 0;
			while (runner != null && idx < n) {
				runner = runner.next;
				idx++;
			}
		}
		while (runner.next != null) {
			walker = walker.next;
			runner = runner.next;
		}
		runner.next = head;
		ListNode newHead = walker.next;
		walker.next = null;
		return newHead;
	}
}
