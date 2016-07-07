package linkedlist;


public class DoublyLinkedList {

	private Node head;
	private int size;

	public int size() {
		return size;
	}

	private static class Node {
		int data;
		Node prev;
		Node next;

		public Node(int data) {
			this.data = data;
			this.prev = null;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();

		System.out.println("Checking add...");
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		System.out.println(list);

		System.out.println("\nChecking insert..");
		list.add(0, 7);
		System.out.println(list);
		list.add(1, 8);
		System.out.println(list);
		list.add(3, 9);
		System.out.println(list);
		list.add(2, 12);
		System.out.println(list);
		list.add(6, 15);
		System.out.println(list);
		list.add(list.size(), 10);
		System.out.println(list);

		System.out.println("\nChecking get..");
		int i;
		for (i = 0; i < list.size(); i++)
			System.out.println(i + " : " + list.get(i));
		System.out.println(i + " : " + list.get(i));

		System.out.println("\nChecking contains()..");
		System.out.println("presence of 1 : " + list.contains(1));
		System.out.println("presence of 2 : " + list.contains(2));
		System.out.println("presence of 3 : " + list.contains(3));
		System.out.println("presence of 0 : " + list.contains(0));
		System.out.println("presence of 5 : " + list.contains(5));
		System.out.println("presence of 6 : " + list.contains(6));
		System.out.println("presence of 16 : " + list.contains(16));

		System.out.println("\nChecking indexOf..");
		System.out.println("index of 5: " + list.indexOf(5));
		System.out.println("index of 0: " + list.indexOf(0));
		System.out.println("index of 4: " + list.indexOf(4));
		System.out.println("index of 1: " + list.indexOf(1));
		System.out.println("index of 6: " + list.indexOf(6));
		System.out.println("index of 2: " + list.indexOf(2));

		System.out.println("\nChecking remove..");
		list.remove(7); // first node
		System.out.println(list.toString());
		list.remove(10); // last node
		System.out.println(list.toString());
		list.remove(15);
		System.out.println(list.toString());
		
		System.out.println("\nChecking findMiddle odd size list..");
		System.out.println(list.findMiddle());
		
		list.remove(6);
		System.out.println(list.toString());
		
		System.out.println("\nChecking findMiddle even size list..");
		System.out.println(list.findMiddle());
//		System.out.println("\nChecking findMiddle with empty list..");
//		list = new DoublyLinkedList();
//		System.out.println(list.findMiddle());
		list.printReverse();
		
		System.out.println("\nChecking reverse..");
		list.reverse();
		System.out.println(list.toString());
		
		list.printReverse(); // this is to check that pointers are updated correctly (valid Doubly linked list)
		
		System.out.println("\nChecking reverse recursively");
		list.reverseRecursive();
		System.out.println(list.toString());
		list.printReverse(); // this is to check that pointers are updated correctly (valid Doubly linked list)
	}
	

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();

		Node tmp = head;
		while (tmp != null) {
			stringBuffer.append(" " + tmp.data);
			tmp = tmp.next;
		}
		stringBuffer.append(" ");

		return "DoublyLinkedList {\n" + "size = " + size + "\n[" + stringBuffer.toString() + "]" + "\n}";
	}

	public int get(int index) {
		int i = 0;
		if (head == null)
			return -1;

		Node tmp = head;
		while (tmp != null) {
			if (i == index) {
				return tmp.data;
			}
			i++;
			tmp = tmp.next;

		}

		return -1;
	}

	public boolean contains(int data) {
		if (head != null) {
			Node tmp = head;
			while (tmp != null) {
				if (tmp.data == data)
					return true;
				tmp = tmp.next;
			}
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

	public void add(int data) {
		if (head == null) {
			head = new Node(data);
			size++;
			return;
		}

		// append node at end

		Node tmp = head;

		while (tmp.next != null) {
			tmp = tmp.next;
		}
		Node newNode = new Node(data);
		tmp.next = newNode;
		newNode.prev = tmp;
		size++;
	}

	public boolean add(int index, int data) {
		if (index < 0 || index > size)
			return false;
		if (index == 0) { // insert at beginning
			Node newNode = new Node(data);
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
			size++;
			return true;
		}

		int i = 0;
		Node tmp = head;
		Node prev = tmp;

		while (tmp.next != null) {
			if (i == index) {
				break;
			}
			i++;
			prev = tmp;
			tmp = tmp.next;
		}
		if (tmp.next == null && index == size) { // insert at end
			Node newNode = new Node(data);
			tmp.next = newNode;
			newNode.prev = tmp;
			size++;
			return true;
		} else {

			Node newNode = new Node(data);
			newNode.next = tmp;
			newNode.prev = prev;
			prev.next = newNode;
			tmp.prev = newNode;
			size++;
		}
		return false;

	}

	public boolean remove(int data) {

		if (head.data == data) { // remove first node
			head.next.prev = null;
			head = head.next;
			size--;
			return true;
		}

		Node tmp = head;
		Node prev = tmp;
		while (tmp != null) {
			if (tmp.data == data) {
				if (tmp.next == null) { // last node
					prev.next = null;
					tmp.prev = null;
					tmp = null;
					size--;
					return true;
				}
				tmp.next.prev = prev;
				prev.next = tmp.next;
				tmp = null;
				size--;
				return true;
			}
			prev = tmp;
			tmp = tmp.next;

		}

		return false;

	}

	public int findMiddle() {
		Node fastPtr = head;
		Node slowPtr = head;

		if (fastPtr != null) {

			while (fastPtr.next != null) {

				if(fastPtr.next.next == null)
					break;
				fastPtr = fastPtr.next.next;
				slowPtr = slowPtr.next;
			}
			return slowPtr.data;
		}

		return -1;
	}
	
	public void reverse() {
		
		Node prev = null;
		Node curr = head;
		Node tmp = curr;
		
		while (curr.next != null) {
			
			tmp = curr;
			curr = curr.next;
			tmp.next = prev;
			tmp.prev = curr;
			prev = tmp;
						
		}
		curr.next = prev;
		prev.prev = curr;
		curr.prev = null;
		head = curr;
	}
	
	public void reverseRecursive() {
		Node curr = head;
		reverseRecursive(curr, null);
	}
	
	public void reverseRecursive(Node curr, Node prev) {
		
		if(curr.next == null) { // Base condition. Last node
			head = curr;
			curr.next = prev;
			curr.prev = null;
			prev.prev = curr;
			
			return;
		}
		
		Node next = curr.next;
		curr.next = prev;
		curr.prev = next;
		reverseRecursive(next, curr);
		
	}
	
	public void printReverse() {
		Node curr = head;
		
		System.out.println("Printing in reverse order");
		while (curr.next != null) {
			curr = curr.next;
		}
		
		while (curr.prev != null) {
			
			System.out.print(" " + curr.data);
			curr = curr.prev;
		}
		System.out.print(" " + curr.data);
		System.out.println();
		
	}
}
