package linkedlist;

import linkedlist.SinglyLinkedList.Node;

public class Problems {

	public static void main(String[] args) {
		
//		SinglyLinkedList list1 = new SinglyLinkedList();
//		list1.add(1);
//		list1.add(2);
//		list1.add(3);
//		list1.add(4);
//		list1.add(5);
//		list1.add(6);
//		SinglyLinkedList list2 = new SinglyLinkedList();
//		list1.add(8);
//		list1.add(8);
//		list1.add(9);
//		list1.add(10);
//		list1.add(11);
//		list1.add(12);
//		mergeSortedLinkedList(list1, list2);
		
//		LinkedList<Character> list1 = new LinkedList<>();
//		list1.add('g');
//		list1.add('e');
//		list1.add('e');
//		list1.add('k');
//		list1.add('s');
//		list1.add('a');
//		LinkedList<Character> list2 = new LinkedList<>();
//		list2.add('g');
//		list2.add('e');
//		list2.add('e');
//		list2.add('k');
//		list2.add('s');
//		list2.add('a');
//		list2.add('a');
//		
//		System.out.println(compareString(list1, list2));

		SinglyLinkedList list1 = new SinglyLinkedList();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
//		list1.add(6);
		
		rearrangeList(list1);
		

	}
	
	// Merge two sorted linked lists such that merged list is in reverse order
	public static void mergeSortedLinkedList(SinglyLinkedList list1, SinglyLinkedList list2) {
		Node a = list1.getHead();
		Node b = list2.getHead();
		SinglyLinkedList resultLsit = new SinglyLinkedList();
		while (a != null && b!= null) {
			if(a.data >= b.data) {
				resultLsit.add(0, a.data);
				a = a.next;
			} else {
				resultLsit.add(0, b.data);
				b = b.next;
			}
		}
		
		while (a != null) {
			resultLsit.add(0, a.data);
			a = a.next;
		}
		
		while (b != null) {
			resultLsit.add(0, b.data);
			b = b.next;
		}
		
		System.out.println(resultLsit);
	}

	public static int compareString(LinkedList<Character> list1, LinkedList<Character> list2) {
		
		linkedlist.LinkedList.Node<Character> a = list1.getFirstNode();
		linkedlist.LinkedList.Node<Character> b = list2.getFirstNode();
		
		while (a != null && b != null) {
			if(a.data != b.data) {
				if(a.data > b.data)
					return 1;
				else
					return -1;
			}
			a = a.next;
			b = b.next;
		}
		
		if(a != null) {
			return 1;
		}
		if(b != null) {
			return -1;
		}
		
		return 0;
	}

	/*	Rearrange a given linked list in-place.
		Given a singly linked list L0 -> L1 -> … -> Ln-1 -> Ln. Rearrange the nodes in the list so that the new formed list is : L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 …
		
		You are required do this in-place without altering the nodes’ values.
		
		Examples:
		Input:  1 -> 2 -> 3 -> 4
		Output: 1 -> 4 -> 2 -> 3
		
		Input:  1 -> 2 -> 3 -> 4 -> 5
		Output: 1 -> 5 -> 2 -> 4 -> 3 
	 */
	public static void rearrangeList(SinglyLinkedList list) {
		Node fastPtr = list.getHead();
		Node slowPtr = fastPtr;
		
		// devide list into two part
		while (fastPtr.next != null) {
			if (fastPtr.next.next == null) {
				break;
			}
			fastPtr = fastPtr.next.next;
			
			slowPtr = slowPtr.next;
		}
		
		
		
		Node list1Head = list.getHead();
		Node list2Head = slowPtr.next;
		slowPtr.next = null;
		
		System.out.println(list);
		
		
		
		while (list2Head != null) {
			
			Node node = list2Head;
			list2Head =list2Head.next;
			
			node.next = list1Head.next;
			list1Head.next = node;
			if(list1Head.next.next != null)
				list1Head = list1Head.next.next;
			
			
		}
		
		System.out.println(list);
	}
	

}
