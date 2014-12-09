package cloneGraph;

import java.util.*;

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};

public class Solution {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
        	return null;
        }
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode> ();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode> ();
        queue.offer(node);
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(node, copy);
        while (!queue.isEmpty()) {
        	UndirectedGraphNode current = queue.poll();
        	for (int i = 0; i < current.neighbors.size(); i++) {
        		if (!map.containsKey(current.neighbors.get(i))) {
        			copy = new UndirectedGraphNode (current.neighbors.get(i).label);
        			map.put(current.neighbors.get(i), copy);
        			queue.offer(current.neighbors.get(i));
        		}
        		map.get(current).neighbors.add(map.get(current.neighbors.get(i)));
        	}
        }
        return map.get(node);
    }
}
