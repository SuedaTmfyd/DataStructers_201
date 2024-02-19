package BinarySearchTree_7;

public class BinarySearchTree {

	public static void main(String[] args) {
		for(int i=1;i<12;i++)
			System.out.println(i);
//		BST tree = new BST();
//		tree.insert(3);
//		tree.insert(1);
//		tree.insert(5);
//		tree.insert(9);
//		tree.insert(7);
//		tree.insert(8);
//		tree.insert(4);
//		tree.print();
	}

}

class Node{
	private Node left;
	private Node right;
	private int value;
	
	Node(int value){
		this.value = value;
	}
	
	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}

class BST{
	private Node root;

	BST(){
		
	}
	
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	public void insert(int value) {
		insert(root, value);		
	}
	
	private Node insert(Node cur, int value) {
		Node newNode = new Node(value);
		if(cur==null) {
			if(root==cur)
				root = newNode;
			cur = newNode;
			return cur;
		}
		
		if(value <= cur.getValue()) {
			cur.setLeft(insert(cur.getLeft(), value));
		}
		else if(value >= cur.getValue()) {
			cur.setRight(insert(cur.getRight(), value));
		}
		
		return cur;
	}
	
	public void print() {
		preOrder(root);
//		inOrder(root);
//		postOrder(root);
	}
	
	private void preOrder(Node cur) {
		if(cur==null)
			return;
		System.out.print(cur.getValue() + " ");
		preOrder(cur.getLeft());
		preOrder(cur.getRight());
	}
	
	private void inOrder(Node cur) {
		if(cur==null)
			return;
		inOrder(cur.getLeft());
		System.out.print(cur.getValue() + " ");
		inOrder(cur.getRight());
	}
	
	private void postOrder(Node cur) {
		if(cur==null)
			return;
		postOrder(cur.getRight());
		System.out.print(cur.getValue() + " ");
		postOrder(cur.getLeft());
	}
	
//	private Node delete(Node cur, int value) {
//		if(cur == null)
//			return cur;
//		if(value < cur.getValue())
//			delete(cur.getLeft(), value);
//		else if( value > cur.getValue())
//			delete(cur.getRight(), value);
//		else if(value == cur.getValue()) {
////			if node has no child
////			if node has 1 child in left/right
////			if node has 2 child
//			if((cur.getLeft() == null) && (cur.getRight() == null))
//				cur = null;
//			else if(!(cur.getLeft() == null) && (cur.getRight() == null))
//				cur.getLeft()
//			
//		}
//	}
	
//	public Node checkVal(int value) {
//		if(root==null) {
//			return root;
//		}
//		
//		Node cur = root;
//		while(!((cur.getLeft() == null) && (cur.getRight() == null))) {
//			if(value < cur)
//		}
//	}
//	public String toString() {
//		return toString(root);
//	}
//	private String toString(Node cur) {
//		String result = "";
//
//		if((cur == null))
//			return "";
//		if((cur.getLeft() == null)) {
//			return result;
//		}
//		if((cur.getRight() == null)) {
//			return result;
//		}
//		result += toString(cur.getLeft());
//		result += toString(cur.getRight());
//		result += root.toString();
//		return result;
//	}
}
