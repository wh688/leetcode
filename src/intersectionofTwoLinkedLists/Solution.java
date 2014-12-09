package intersectionofTwoLinkedLists;
/*
Write a program to find the node at which the intersection of two singly linked lists begins.
*/
import java.util.*;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int nA = 0;
        int nB = 0;
        ListNode headAcopy = headA;
        ListNode headBcopy = headB;
        while (headA != null) {
        	nA ++;
        	headA = headA.next;
        }
        while (headB != null) {
        	nB ++;
        	headB = headB.next;
        }
        int diff = Math.abs(nA - nB);
        if (nA >= nB) {
        	for (int i = 0; i < diff; i++) {
        		headAcopy = headAcopy.next;
        	}
        } else {
        	for (int i = 0; i < diff; i++) {
        		headBcopy = headBcopy.next;
        	}        	
        }
        while (headAcopy != null) {
    		if (headAcopy == headBcopy) {
    			return headAcopy;
    		}
    		headAcopy = headAcopy.next;
    		headBcopy = headBcopy.next;
    	}
        return null;
    }
}