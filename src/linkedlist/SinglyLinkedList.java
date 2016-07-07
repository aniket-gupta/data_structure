package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class SinglyLinkedList {

	private int size;
	private Node head;
	private Node lastNode;

	public static class Node { // this class should be private.
		public int data;
		public Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public int getSize() {
		return size;
	}

	public Node getHead() {
		return head;
	}

	public Node getLastNode() {
		return lastNode;
	}

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		System.out.println("\nChecking add..");
//		list.add(1);
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.add(4);
//		list.add(5);
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.add(4);
//		list.add(5);
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		System.out.println(list.toString());
		list.partionList(list.getHead(), 3);
//		System.out.println(list.toString());
		// list.removeDup(list.getHead());
		// list.removeDupNoBuff(list.getHead());
		// System.out.println(list.toString());
//		list.kthElemFromLast(list.getHead(), 3);
		// System.out.println("\nChecking remove..");
		// list.remove(1);
		// System.out.println(list.toString());
		// list.remove(3);
		// System.out.println(list.toString());
		// list.remove(5);
		// System.out.println(list.toString());
		// list.remove(1);
		// System.out.println(list.toString());
		// System.out.println("\nChecking insert..");
		// list.add(0, 5);
		// System.out.println(list.toString());
		// list.add(list.getSize(), 1);
		// System.out.println(list.toString());
		// list.add(2, 3);
		// System.out.println(list.toString());
		//
		// System.out.println("\nChecking get..");
		// for (int i = 0; i < list.getSize(); i++) {
		// System.out.println(i + ": " + list.get(i));
		// }
		// System.out.println("\nChecking contains..");
		// System.out.println("presence of 5: " + list.contains(5));
		// System.out.println("presence of 0: " + list.contains(0));
		// System.out.println("presence of 4: " + list.contains(4));
		// System.out.println("presence of 1: " + list.contains(1));
		// System.out.println("presence of 6: " + list.contains(6));
		// System.out.println("presence of 2: " + list.contains(2));
		// System.out.println("\nChecking indexOf..");
		// System.out.println("index of 5: " + list.indexOf(5));
		// System.out.println("index of 0: " + list.indexOf(0));
		// System.out.println("index of 4: " + list.indexOf(4));
		// System.out.println("index of 1: " + list.indexOf(1));
		// System.out.println("index of 6: " + list.indexOf(6));
		// System.out.println("index of 2: " + list.indexOf(2));
		//
		// System.out.println("\nChecking reverse");
		// list.reverse();
		// System.out.println(list.toString());
		//
		// System.out.println("\nChecking reverse iteratively");
		// list.reverseIterative();
		// System.out.println(list.toString());
		//
		// System.out.println("\nChecking findMiddle() with odd size list");
		// System.out.println(list.findMiddle());
		//
		// list.remove(1);
		// System.out.println(list.toString());
		//
		// System.out.println("\nChecking findMiddle() with even size list");
		// System.out.println(list.findMiddle());

	}

	public int get(int index) {
		Node tmp = head;
		if (tmp == null) {
			System.err.println("List is empty");
			return -1;
		} else if (index >= size || index < 0) {

			System.err.println("invalid index");
			return -1;
		}
		int i = 0;
		while (tmp != null) {

			if (i == index) {
				return tmp.data;
			}
			tmp = tmp.next;
			i++;
		}
		return -1;

	}

	public boolean add(int data) {
		if (size == 0) {
			head = new Node(data);
			lastNode = head;
			size++;
			return true;
		}
		Node tmp = head;
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		Node newNode = new Node(data);
		tmp.next = newNode;
		lastNode = newNode;
		size++;
		return true;
	}

	public boolean add(int index, int data) {
		if (index > size) {
			return false;
		}
		// insert at beginning
		if (index == 0) {
			if (head == null) {
				head = new Node(data);
				size++;
				return true;
			}
			Node tmp = new Node(data);
			tmp.next = head;
			head = tmp;
			size++;
			return true;
		}
		// insert at end
		if (index == size) {
			Node newNode = new Node(data);
			lastNode.next = newNode;
			lastNode = newNode;
			size++;
			return true;
		}
		int i = 0;
		Node tmp = head;
		Node prevNode = tmp;
		while (tmp != null) {
			if (i == index) {
				Node node = new Node(data);
				node.next = tmp;
				prevNode.next = node;
				size++;
				return true;
			}
			i++;
			prevNode = tmp;
			tmp = tmp.next;
		}
		return false;
	}

	public boolean remove(int data) {
		if (size == 0) {
			return false;
		}
		// if first node
		if (head.data == data) {
			head = head.next;
			size--;
			return true;
		}
		Node tmp = head;
		Node prevNode = tmp;
		while (tmp != null) {

			if (tmp.data == data) {
				if (tmp.next == null) { // update last node
					lastNode = prevNode;
				}
				prevNode.next = tmp.next;
				size--;
				return true;
			}
			prevNode = tmp;
			tmp = tmp.next;
		}
		return false;

	}

	public boolean remove(Node node) {

		// if node is last node this method will not work
		if (null == node.next) {
			return false;
		}

		Node nextNode = node.next;

		node.data = nextNode.data;
		node.next = nextNode.next;
		size--;
		return true;
	}

	public void reverse() {
		reverse(head, null);
	}

	public void reverse(Node curr, Node prev) {

		// If only node
		if (curr.next == null) {
			head = curr;
			curr.next = prev;
			return;
		}
		Node next = curr.next;
		curr.next = prev;
		reverse(next, curr);
	}

	public void reverseIterative() {
		Node prev = null;
		Node temp = head;
		while (head.next != null) {
			head = head.next;
			temp.next = prev;
			prev = temp;
			temp = head;
		}
		temp.next = prev;
		head = temp;
	}

	public boolean contains(int data) {
		Node tmp = head;
		while (tmp != null) {
			if (tmp.data == data)
				return true;
			tmp = tmp.next;
		}
		return false;
	}

	public int indexOf(int data) {
		Node tmp = head;
		int i = 0;
		while (tmp != null) {
			if (tmp.data == data)
				return i;
			tmp = tmp.next;
			i++;
		}
		return -1;
	}

	public int findMiddle() {
		if (head == null) {
			return -1;
		} else if (head.next == null) {
			return head.data;
		} else {
			// Tortoise and here method
			Node fastPtr = head;
			Node slowPtr = head;
			while (fastPtr.next != null) {
				if (fastPtr.next.next == null) {
					break;
				}
				fastPtr = fastPtr.next.next;
				slowPtr = slowPtr.next;
			}
			return slowPtr.data;
		}
	}

	public void removeDup(Node head) {
		if (head == null) {
			return;
		}
		Map<Integer, Boolean> table = new HashMap<>();
		Node curr = head;
		Node prev = curr;
		while (curr != null) {
			if (table.containsKey(curr.data)) {
				prev.next = curr.next;
			} else {
				table.put(curr.data, true);
				prev = curr;
			}
			curr = curr.next;
		}
	}

	public void removeDupNoBuff(Node head) {
		Node curr = head;
		while (curr != null) {
			Node nextNode = curr;
			while (nextNode.next != null) {
				if (nextNode.next.data == curr.data) {
					nextNode.next = nextNode.next.next;
				} else {
					nextNode = nextNode.next;
				}

			}
			curr = curr.next;
		}
	}

	public void kthElemFromLast(Node head, int k) {
		if (head == null)
			return;
		int count = 0;
		Node ptrAhead = head;
		while (count < k) {
			if (ptrAhead == null)
				return;
			ptrAhead = ptrAhead.next;
			count++;
		}
		Node curr = head;
		while (ptrAhead != null) {
			curr = curr.next;
			ptrAhead = ptrAhead.next;
		}
		System.out.println(curr.data);
	}

	public void partionList(Node head, int x) {
		if (head == null)
			return;
		Node beforeStart = null;
		Node beforeEnd = null;
		Node afterStart = null;
		Node afterEnd = null;
		Node node = head;
		while (node != null) {
			Node next = node.next;
			node.next = null;
			if (node.data < x) {
				if (beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
			} else {
				if(node.data == x) {
					if (afterStart == null) {
						afterStart = node;
						afterEnd = afterStart;
					} else {
						node.next = afterStart;
						afterStart = node;
					}
				}
				else if (afterStart == null) {
					afterStart = node;
					afterEnd = afterStart;
				} else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			node = next;
		}
		
		beforeEnd.next = afterStart;
		
//		head = beforeStart;
//		if(afterStart != null) {
//			beforeEnd.next = afterStart;
//			afterEnd.next = null;
//		}
//		
		while (beforeStart != null) {
			System.out.print(beforeStart.data + "-->");
			beforeStart = beforeStart.next;
		}
		
	}
	
//	public void qsort(Node head) {
//		
//	}
//	
//	private Node partition(Node prev, Node firstNode, Node lastNode) {
//		Node pivot = lastNode;
//		while(firstNode != pivot) {
//			if(firstNode.data > pivot.data) {
//				prev.next = firstNode.next;
//				firstNode.next = lastNode.next;
//				lastNode.next = firstNode;
//				lastNode = firstNode;
//				firstNode = prev.next;
//			}
//		}
//		return pivot;
//	}

	

	@Override
	public String toString() {

		Node tmp = head;
		StringBuffer stringBuffer = new StringBuffer();
		while (tmp != null) {
			stringBuffer.append(tmp.data + "-->");
			tmp = tmp.next;
		}
		stringBuffer.append("NULL");
		return "SinglyLinkedList: [\n" + "size: " + size + "\n" + stringBuffer.toString() + "\n]";
	}

}
