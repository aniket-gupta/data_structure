package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BST {

	public Node root;

	public static class Node {

		public int data;
		public Node left;
		public Node right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

	}

	public static void main(String[] args) {
		BST bst = new BST();
		bst.insert(5);
		bst.insert(2);
		bst.insert(7);
		bst.insert(1);
		bst.insert(3);
		bst.insert(6);
		bst.insert(8);
		bst.insert(9);
		bst.insert(10);
		// bst.printInorder();
		// Node root = new Node(1);
		// root.left = new Node(2);
		// root.left.left = new Node(4);
		// root.left.left.left = new Node(8);
		// root.left.right = new Node(5);
		// root.left.right.right = new Node(9);
		// root.right = new Node(3);
		// root.right.left = new Node(6);
		// root.right.right = new Node(7);
		// System.out.println(new BST().isBalanced(root));
		// lowestCommonAncestor(root, 7, 8);
		// System.out.println(lowestCommonAncestor1(root, 9, 8).data);
		// System.out.println(findMin(bst.root));
		// System.out.println(inorderSuccessor(bst.root, 3));
		// invert(bst.root);
		// System.out.println();
		// bst.printInorder();
		// System.out.println(isBalanced(bst.root));
		// System.out.println(isBST(bst.root));

		int[] A = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		Node root = bstFromSortedArray(null, A, 0, A.length - 1);
		System.out.println(root.data);
		bst.printInorder(root);
	}

	public void insert(int data) {
		if (root == null)
			root = insert(root, data);
		else {
			Node tmp = root;
			insert(tmp, data);
		}
	}

	public Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);

		}
		if (data < root.data)
			root.left = insert(root.left, data);
		else {
			root.right = insert(root.right, data);
		}

		return root;

	}

	public void printInorder() {
		Node tmp = root;
		printInorder(tmp);
	}

	public void printInorder(Node root) {
		if (root != null) {
			printInorder(root.left);
			System.out.print(" " + root.data);
			printInorder(root.right);
		}
	}

	public static int getHeight(Node root) {
		if (root == null) {
			return 0;
		} else {
			return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
		}
	}

	public static void inorder(Node root, List<Integer> list) {
		if (root != null) {
			inorder(root.left, list);
			list.add(root.data);
			inorder(root.right, list);
		}
	}

	public static void postorder(Node root, List<Integer> list) {
		if (root != null) {
			postorder(root.left, list);
			postorder(root.right, list);
			list.add(root.data);
		}
	}

	public static void lowestCommonAncestor(Node root, int n1, int n2) {
		List<Integer> listInorder = new ArrayList<>();
		List<Integer> listPostorder = new ArrayList<>();
		inorder(root, listInorder);
		postorder(root, listPostorder);
		int indexN1 = listInorder.indexOf(n1);
		int indexN2 = listInorder.indexOf(n2);
		if (indexN1 < 0 || indexN2 < 0)
			return;
		// index range of possible ancestor
		int startIndex = indexN1 + 1;
		int endIndex = indexN2 - 1;
		if (indexN1 > indexN2) {
			startIndex = indexN2 + 1;
			endIndex = indexN1 - 1;
		}
		int max = listPostorder.indexOf(listInorder.get(startIndex));
		for (int i = startIndex + 1; i <= endIndex; i++) {
			int index = listPostorder.indexOf(listInorder.get(i));
			max = max > index ? max : index;
		}
		System.out.println(listPostorder.get(max));
	}

	public static Node lowestCommonAncestor1(Node root, int n1, int n2) {
		if (root == null)
			return null;
		if (root.data == n1 || root.data == n2)
			return root;
		Node leftAncestor = lowestCommonAncestor1(root.left, n1, n2);
		Node rightAncestor = lowestCommonAncestor1(root.right, n1, n2);
		if (leftAncestor != null && rightAncestor != null)
			return root;
		return leftAncestor == null ? rightAncestor : leftAncestor;
	}

	public static int findMin(Node root) {
		if (root == null)
			return -1;
		if (root.left == null)
			return root.data;
		return findMin(root.left);
	}

	public static int findMax(Node root) {
		if (root == null)
			return -1;
		if (root.right == null)
			return root.data;
		return findMax(root.right);
	}

	public static Node findNode(Node root, int n) {
		if (root == null)
			return null;
		if (root.data == n)
			return root;
		if (n < root.data)
			return findNode(root.left, n);
		else
			return findNode(root.right, n);
	}

	public static int inorderSuccessor(Node root, int n) {
		Node node = findNode(root, n);
		if (node == null)
			return -1;
		if (node.right != null)
			return findMin(node.right);
		else {
			int succ = n;
			while (root != null) {

				if (n < root.data) {
					succ = root.data;
					root = root.left;
				} else
					root = root.right;

			}
			return succ == n ? -1 : succ;
		}
	}

	public static void invert(Node root) {
		if (root != null) {
			invert(root.left);
			invert(root.right);
			Node tmp = root.right;
			root.right = root.left;
			root.left = tmp;
		}
	}

	public static boolean isBalanced(Node root) {
		if (root == null)
			return true;
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		int diff = leftHeight - rightHeight;
		if (diff > 1 || diff < -1)
			return false;
		return isBalanced(root.left) && isBalanced(root.right);
	}

	public static boolean isBST(Node root) {
		if (root == null) {
			return true;
		}
		if (root.left != null && root.data < findMax(root.left))
			return false;
		if (root.right != null && root.data >= findMin(root.right))
			return false;

		if (!isBST(root.left) || !isBST(root.right))
			return false;
		return true;
	}

	public static Node bstFromSortedArray(Node root, int[] A, int startIndex, int endIndex) {
		if (endIndex < startIndex)
			return null;

		int mid = (startIndex + endIndex) / 2;
		if (root == null) {
			root = new Node(A[mid]);

		}
		root.left = bstFromSortedArray(root.left, A, startIndex, mid - 1);
		root.right = bstFromSortedArray(root.right, A, mid + 1, endIndex);

		return root;

	}

}
