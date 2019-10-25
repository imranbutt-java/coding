package com.practice.coding.common;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLinkedList {
	
	public static void main(String[] args) {
		MergeKSortedLinkedList cla = new MergeKSortedLinkedList();
		cla.mergeKLists();
	}
	
	public void mergeKLists() {
		ListNode a = new ListNode(2);
		a.next = new ListNode(4);
		ListNode b = new ListNode(1);
		b.next = new ListNode(3);
		ListNode c = new ListNode(0);
		c.next = new ListNode(5);
		
		ListNode[] arr = {a, b, c};
		
		ListNode result = mergeKLists(arr);
		System.out.println(result);
	}
	
	public ListNode mergeKLists(ListNode[] lists) {

        if (lists==null||lists.length==0) return null;
        
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else 
                    return 1;
            }
        });
        
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        
        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);
            
        while (!queue.isEmpty()){
            tail.next=queue.poll();
            System.out.println("Node removed from queue: "+tail.next.val);
            tail=tail.next;
            System.out.println("Have next: "+(tail.next != null));
            if (tail.next!=null) {
            	System.out.println("Adding Node in queue: "+tail.next.val);
            	queue.add(tail.next);
            }
                
        }
        return dummy.next;
    }

}

class ListNode {
	ListNode next;
	int val;
	ListNode(int val) {
		this.val = val;
	}
}
