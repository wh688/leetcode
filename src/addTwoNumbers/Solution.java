package addTwoNumbers;

import java.util.LinkedList;

/**
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * @author HWT
 *
 */

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		int sum = 0;
		int carry = 0;		
		int p = 0;
		int q = 0;
		
		ListNode fakeHead = new ListNode(-1);
		ListNode result = fakeHead;
		while (l1 != null || l2 != null) {
			if (l1 != null) {
				carry += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				carry += l2.val;
				l2 = l2.next;
			}
			result.next = new ListNode(carry % 10);
			carry = carry / 10;
			result = result.next;
		}
		if(carry == 1) {
			result.next = new ListNode(1);
		}
		return fakeHead.next;
	}
}
