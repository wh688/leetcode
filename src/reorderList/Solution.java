package reorderList;

/*
Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn,
reorder it to: L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­
You must do this in-place without altering the nodes' values.
For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}. 
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
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		ListNode slow = head;
		ListNode fast = head;
		ListNode first = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode second = slow.next;
		slow.next = null;
		second = reverse(second);
		while(second != null) {
			ListNode temp1 = first.next;
			ListNode temp2 = second.next;
			first.next = second;
			second.next = temp1;
			first = temp1;
			second = temp2;
		}
    }
	
	public ListNode reverse (ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = head;
		ListNode curr = head.next;
		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = pre;
			pre = curr;
			curr = temp;
		}
		head.next = null;
		return pre;
	}
}
