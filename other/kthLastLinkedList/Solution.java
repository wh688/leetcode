package kthLastLinkedList;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

class Solution {
	public ListNode getkthLast(ListNode head, int k) {
		if (k < 1 || head == null) {
			return null;
		}
		ListNode ptr1 = head;
		ListNode ptr2 = head;
		for (int i = 0; i < k; i++) {
			ptr2 = ptr2.next;
			if (ptr2 == null) {
				return null;				
			}
		}
		while (ptr2 != null) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		return ptr1;
	}
}