package bstOps;

public class BstOpsNode {
	
	public static class Node {
		int value;
		Node left;
		Node right;
		
		public Node(int value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	public static void insert(Node node, int val) {
		if (node == null) {
			node = new Node(val, null, null);
		}
		
		if (val < node.value) {
			if (node.left == null) {
				node.left = new Node(val, null, null);
			} else {
				insert(node.left, val);
			}
		} else {
			if (node.right == null) {
				node.right = new Node(val, null, null);
			} else {
				insert(node.right, val);
			}
		}
	}
	
	public static boolean find(Node node, int val) {
		if (node == null) return false;
		
		if (val == node.value) {
			return true;
		}
		
		return find(node.left, val) || find(node.right, val);
	}
	
	public static void delete(Node node, int val) {
		if (node == null) return;
		
		if (val == node.value) {
			node = null;
			return;
		}
		
		if (val < node.value) {
			delete(node.left, val);
		} else {
			delete(node.right, val);
		}
	}
	
	public static void traverse(Node node) {
		if (node == null) return;
		traverse(node.left);
		System.out.println(node.value);
		traverse(node.right);
	}
	
	public static void main(String[] args) {
		Node root = new Node(4, null, null);
		insert(root, 5);
		insert(root, 20);
		insert(root, 3);
		insert(root, 14);
		traverse(root);
	}
}
