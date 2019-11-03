package mergeKSortedLists;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * 
 * LeetCode Hard
 * 10/31 10:50 -> 11:25
 * @author aaronhsu
 *
 */

public class MergeKSortedLists {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static ListNode mergeKLists(ListNode[] lists) {
		Comparator comparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode node1, ListNode node2) {
            	return node1.val - node2.val;
            }
        };
		PriorityQueue<ListNode> pq = new PriorityQueue<>(comparator);
		
		// initialize PQ
		for (ListNode node : lists) {
			if (node != null) {
				pq.add(node);
			}
		}
		
		// Done when PQ has nothing left which means we've gone through all lists
		ListNode root = null;
		ListNode prev = root;
		while (!pq.isEmpty()) { 
			ListNode currNode = pq.poll();
			
			if (root == null) {
				root = currNode;
				prev = root;
			} else {
				prev.next = currNode;
				prev = prev.next;
			}
			
			if (currNode.next != null) {
				currNode = currNode.next;
				pq.add(currNode);
			}
		}
		
		return root;
    }
    
    public static void main(String[] args) {
    	ListNode[] list = new ListNode[3];
    	list[0] = new ListNode(1);
    	list[0].next = new ListNode(4);
    	list[0].next.next = new ListNode(5);
    	list[1] = new ListNode(1);
    	list[1].next = new ListNode(3);
    	list[1].next.next = new ListNode(4);
    	list[2] = new ListNode(2);
    	list[2].next = new ListNode(6);
    	list[2].next.next = new ListNode(7);
    	list[2].next.next.next = new ListNode(8);
    	
    	ListNode curr = mergeKLists(list);
    	System.out.println("------------------");
    	while (curr != null) {
    		System.out.print(curr.val + " ");
    		curr = curr.next;
    	}
    }
}
