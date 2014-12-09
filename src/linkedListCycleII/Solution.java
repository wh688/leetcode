package linkedListCycleII;

/*Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
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
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
        	if (fast == null || fast.next == null)
        		return null;
        	slow = slow.next;
        	fast = fast.next.next;
        	if (fast == slow)
        		break;
        }
        ListNode result = head;
        while (result != fast) {
        	result = result.next;
        	fast = fast.next;
        }
        return result;
    }
}
