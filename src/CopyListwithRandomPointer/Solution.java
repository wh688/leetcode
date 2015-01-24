package CopyListwithRandomPointer;

import java.util.*;

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
	this.label = x;
    }
};

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
	if (head == null) {
	    return null;
	}
	HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
	RandomListNode newHead = new RandomListNode(head.label);
	map.put(head, newHead);
	RandomListNode pre = newHead;
	RandomListNode node = head.next;
	while (node != null) {
	    RandomListNode newNode = new RandomListNode(node.label);
	    map.put(node, newNode);
	    pre.next = newNode;
	    pre = newNode;
	    node = node.next;
	}
	node = head;
	RandomListNode copyNode = newHead;
	while (node != null) {
	    copyNode.random = map.get(node.random);
	    copyNode = copyNode.next;
	    node = node.next;
	}
	return newHead;
    }
}
