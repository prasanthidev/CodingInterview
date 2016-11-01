package com.ib.linkedlist;

import java.util.List;

/*
 * Definition for singly-linked list.
 */

public class ListNode {
	
     public int val;
     public ListNode next;
     
     public ListNode(int x) { 
    	 val = x; 
    	 next = null; 
     }
          
     public static ListNode createList(List<Integer> a){
    	 ListNode temp1 = new ListNode(a.get(0));
    	 ListNode head = temp1;
    	 for(int i=1; i<a.size(); i++){
    		 ListNode temp2 = new ListNode(a.get(i));
    		 temp1.next = temp2;
    		 temp1 = temp1.next;
    	 }
    	 return head;
     }
     
     public static int length(ListNode a){
    	 ListNode head = a;
    	 if(head == null)
    		 return 0;
    	 int length = 1;
    	 while(head.next != null){
    		 head = head.next;
    		 length++;
    	 }
    	 return length;
     }
     
     public static ListNode reverse(ListNode a){
    	 ListNode head = a;
    	 ListNode tail = lastNode(a);
    	 ListNode temp1 = null, temp2 = null;
    	 while(head != tail){
    		 temp1 = head.next;
    		 head.next = temp2;
    		 tail.next = head;
    		 temp2 = head;
    		 head = temp1;
    	 }    	 
    	 return head;
     }
     
     public static ListNode lastNode(ListNode a){
    	 ListNode head = a;
    	 while(head.next != null){
    		 head = head.next;
    	 }
    	 return head;
     }
     
     public static ListNode intersectionOfList(ListNode a, ListNode b){
    	 int m = length(a);
    	 int n = length(b);
    	 int length = m - n;
    	 if(m < n){
    		 ListNode temp = a;
    		 a = b;
    		 b = temp;
    		 length = n - m;
    	 }    	 
    	 while(length>0)
    		 a = a.next;
    	 while(a != null){
    		 if(a == b){
    			 return a;
    		 }
    		 a = a.next;
    		 b = b.next;
    	 }
    	 return null;
     }

	public static void printList(ListNode c) {
		while(c!=null){
			System.out.print(c.val + "->");
			c = c.next;
		}
	}
     
}
