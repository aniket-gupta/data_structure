package linkedlist;


public class CircularLinkedList {

	private Node head;
	private Node lastNode;
	private int size;

	private static class Node {

		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}

	}

	public static void main(String[] args) {
		CircularLinkedList list = new CircularLinkedList();

		System.out.println("\nChecking add..");
		list.add(1);
		System.out.println(list.toString());
		list.add(2);
		System.out.println(list.toString());
		list.add(3);
		System.out.println(list.toString());
		list.add(4);
		System.out.println(list.toString());
		list.add(5);
		System.out.println(list.toString());

		System.out.println("\nChecking insert..");
		list.add(0, 5);
		System.out.println(list.toString());
		list.add(list.size(), 6);
		System.out.println(list.toString());
		list.add(1, 15);
		System.out.println(list.toString());
		list.add(3, 12);
		System.out.println(list.toString());
		list.add(2, 16);
		System.out.println(list.toString());

		System.out.println("\nChecking remove...");
		list.remove(5);
		System.out.println(list.toString());
		list.remove(6);
		System.out.println(list.toString());
		list.remove(5);
		System.out.println(list.toString());
		list.remove(12);
		System.out.println(list.toString());

		System.out.println("\nChecking contains..");
		System.out.println("presence of 15: " + list.contains(15));
		System.out.println("presence of 16: " + list.contains(16));
		System.out.println("presence of 5: " + list.contains(5));
		System.out.println("presence of 0: " + list.contains(0));
		System.out.println("presence of 4: " + list.contains(4));
		System.out.println("presence of 1: " + list.contains(1));
		System.out.println("presence of 6: " + list.contains(6));
		System.out.println("presence of 2: " + list.contains(2));
		System.out.println("\nChecking indexOf..");
		System.out.println("index of 15: " + list.indexOf(15));
		System.out.println("index of 16: " + list.indexOf(16));
		System.out.println("index of 5: " + list.indexOf(5));
		System.out.println("index of 0: " + list.indexOf(0));
		System.out.println("index of 4: " + list.indexOf(4));
		System.out.println("index of 1: " + list.indexOf(1));
		System.out.println("index of 6: " + list.indexOf(6));
		System.out.println("index of 2: " + list.indexOf(2));
		
		System.out.println("\nChecking get..");
		int i;
		for (i = 0; i < list.size(); i++)
			System.out.println(i + " : " + list.get(i));
		System.out.println(i + " : " + list.get(i));


	}

	public int size() {
		return size;
	}

	public int get(int index) {
		if (head != null) {
			if (index == 0) {
				return head.data;
			}
			Node curr = head.next;
			int i = 1;
			while (curr != head) {
				if (i == index)
					return curr.data;
				curr = curr.next;
				i++;
			}
		}
		return -1;
	}

	public int indexOf(int data) {

		if (head.data == data) {
			return 0;
		}
		Node curr = head.next;
		int i = 1;
		while (curr != head) {
			if (curr.data == data)
				return i;
			curr = curr.next;
			i++;
		}
		return -1;
	}

	public boolean contains(int data) {
		return indexOf(data) != -1;
	}

	public void add(int data) {
		if (head == null) {
			head = new Node(data);
			head.next = head;
			lastNode = head;
			size++;
			return;
		}

		Node curr = head;
		while (curr.next != head) {
			curr = curr.next;
		}

		curr.next = new Node(data);
		lastNode = curr.next;
		curr.next.next = head;
		size++;
	}

	public boolean add(int index, int data) {
		if (index < 0 && index > size)
			return false;
		if (index == 0) {
			Node newNode = new Node(data);
			newNode.next = head;
			head = newNode;
			lastNode.next = head;
			size++;
			return true;
		} else if (index == size) {
			Node newNode = new Node(data);
			lastNode.next = newNode;
			newNode.next = head;
			lastNode = newNode;
			size++;
			return true;
		} else {
			Node curr = head;
			int i = 0;
			Node tmp = curr;
			for (i = 0; curr.next != head; tmp = curr, curr = curr.next, i++) {
				if (i == index) {
					Node newNode = new Node(data);
					newNode.next = curr;
					tmp.next = newNode;
					size++;
				}
			}
		}

		return false;
	}

	public boolean remove(int data) {

		if (head.data == data) {
			Node newHead = head.next;
			head.next = null;
			head = newHead;
			lastNode.next = head;
			size--;
			return true;
		} else {
			Node curr = head;
			Node tmp = curr;

			while (curr.next != head) {
				if (curr.data == data) {
					tmp.next = curr.next;
					curr.next = null;
					size--;
					return true;
				}
				tmp = curr;
				curr = curr.next;
			}

			if (curr.data == data) { // lastnode
				tmp.next = curr.next;
				curr.next = null;
				lastNode = tmp;
				size--;
				return true;
			}

		}

		return false;

	}

	
	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();

		Node curr = head;
		while (curr.next != head) {
			stringBuffer.append(" " + curr.data);
			curr = curr.next;
		}
		stringBuffer.append(" " + curr.data + " ");

		return "CircularLinkedList {\n" + "size = " + size + "\n[" + stringBuffer.toString() + "]" + "\n}";
	}

}
